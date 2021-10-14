package com.example.retokmm.android.ui.comic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.retokmm.android.databinding.FragmentComicBinding
import com.example.retokmm.android.core.showSnackbar
import com.example.retokmm.model.ComicShared
import com.example.retokmm.util.Resource
import com.example.retokmm.util.Status
import com.example.retokmm.viewModel.ComicsListViewModel

class ComicFragment : Fragment(), ClickComic {

    private lateinit var mBinding: FragmentComicBinding
    private lateinit var comicsListViewModel: ComicsListViewModel
    private lateinit var comicsListObserver: (state: Resource<List<ComicShared>>) -> Unit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentComicBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comicsListViewModel = ViewModelProvider(this).get(ComicsListViewModel::class.java)
        comicsListViewModel.getInformation(false)

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
                result.data?.let {
                    mBinding.recyclerViewComic.adapter = ComicAdapter(it, this)
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