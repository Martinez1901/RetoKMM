package com.example.retokmm.android.ui.search

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retokmm.android.core.showSnackbar
import com.example.retokmm.android.ui.comic.ClickComic
import com.example.retokmm.android.ui.comic.ComicAdapter
import com.example.retokmm.model.ComicShared
import com.example.retokmm.util.Resource
import com.example.retokmm.util.Status
import com.example.retokmm.viewModel.ComicsViewModel


class SearchComicFragment : SearchContentFragment(), ClickComic {

    private lateinit var comicsViewModel: ComicsViewModel
    private lateinit var comicsObserver: (state: Resource<List<ComicShared>>) -> Unit
    private val adapter = ComicAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.recyclerViewSearch.layoutManager = GridLayoutManager(context, 2)
        mBinding.recyclerViewSearch.adapter = adapter
        comicsViewModel = ViewModelProvider(this).get(ComicsViewModel::class.java)
        listener()
        mBinding.progressBar.isVisible = false
    }

    override fun listener() {
        comicsObserver = {
            getDataListState(comicsViewModel.comics.value)
        }
        comicsViewModel.comics.addObserver(comicsObserver)
    }

    override fun clickSearch(name: String) {
        if (name.isEmpty()) {
            mBinding.root.showSnackbar("Favor ingresa el nombre de un comic.")
        } else {
            adapter.submitList(emptyList())
            comicsViewModel.searchComics(name)
        }
    }

    override fun <T> getDataListState(result: Resource<List<T>>) {
        when (result.status) {
            Status.SUCCESS -> {
                mBinding.progressBar.isVisible = false
                if (result.data.isNullOrEmpty()) {
                    mBinding.root.showSnackbar("Comic no encontrado")
                } else {
                    result.data!!.filterIsInstance<ComicShared>().apply {
                        adapter.submitList(this)
                    }
                }

            }
            Status.LOADING -> {
                println("entroooooooo")
                mBinding.progressBar.isVisible = true
            }

            Status.ERROR -> {
                mBinding.progressBar.isVisible = false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        comicsViewModel.comics.removeObserver { comicsObserver }
    }

    override fun onClick(comic: ComicShared) {
        mBinding.root.showSnackbar("Comic seleccionado ${comic.title}")
    }
}