package com.example.retokmm.android.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.retokmm.android.core.showSnackbar
import com.example.retokmm.android.databinding.FragmentSearchContentBinding
import com.example.retokmm.android.ui.comic.ClickComic
import com.example.retokmm.android.ui.comic.ComicAdapter
import com.example.retokmm.model.ComicShared
import com.example.retokmm.util.Resource
import com.example.retokmm.util.Status
import com.example.retokmm.viewModel.ComicsListViewModel


class SearchContentFragment : Fragment(), ClickComic {

    private lateinit var mBinding: FragmentSearchContentBinding
    private lateinit var comicsListViewModel: ComicsListViewModel
    private lateinit var comicsListObserver: (state: Resource<List<ComicShared>>) -> Unit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSearchContentBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tieSearch.requestFocus()

        comicsListViewModel = ViewModelProvider(this).get(ComicsListViewModel::class.java)
        comicsListViewModel.searchComics("")

        mBinding.btnSearch.setOnClickListener {
            mBinding.progressBar.isVisible = true
            comicsListViewModel.searchComics(mBinding.tieSearch.text.toString())
        }

        listener()
    }

    private fun listener() {
        comicsListObserver = {
            getComicsListState(comicsListViewModel.comics.value)
        }
        comicsListViewModel.comics.addObserver(comicsListObserver)
    }

    private fun getComicsListState(result: Resource<List<ComicShared>>) {
        when (result.status) {
            Status.SUCCESS -> {
                mBinding.progressBar.isVisible = false

                if (result.data.isNullOrEmpty()) {
                    mBinding.root.showSnackbar("Comic no encontrado")
                } else {
                    mBinding.recyclerViewSearch.adapter = ComicAdapter(result.data!!, this)
                }
            }
            Status.LOADING -> {
                mBinding.progressBar.isVisible = true
            }

            Status.ERROR -> {
                mBinding.progressBar.isVisible = false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        comicsListViewModel.comics.removeObserver { comicsListObserver }
    }

    override fun onClick(comic: ComicShared) {
        mBinding.root.showSnackbar("Comic seleccionado ${comic.title}")
    }
}