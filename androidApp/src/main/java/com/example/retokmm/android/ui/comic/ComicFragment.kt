package com.example.retokmm.android.ui.comic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.retokmm.android.core.showSnackbar
import com.example.retokmm.android.databinding.FragmentComicBinding
import com.example.retokmm.model.ComicShared
import com.example.retokmm.util.Resource
import com.example.retokmm.util.Status
import com.example.retokmm.viewModel.ComicsViewModel
import com.google.gson.Gson

class ComicFragment : Fragment(), ClickComic {

    private lateinit var mBinding: FragmentComicBinding
    private lateinit var comicsViewModel: ComicsViewModel
    private lateinit var comicsObserver: (state: Resource<List<ComicShared>>) -> Unit
    private val adapter = ComicAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentComicBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.recyclerViewComic.adapter = adapter
        comicsViewModel = ViewModelProvider(this).get(ComicsViewModel::class.java)
        comicsViewModel.getInformation(false)

        listener()
    }

    private fun listener() {
        comicsObserver = {
            getComicsListState(comicsViewModel.comics.value)
        }
        comicsViewModel.comics.addObserver(comicsObserver)
    }

    private fun getComicsListState(result: Resource<List<ComicShared>>) {
        when (result.status) {
            Status.SUCCESS -> {
                mBinding.progressBar.isVisible = false
                result.data?.let {
                    adapter.submitList(it)
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
        comicsViewModel.comics.removeObserver { comicsObserver }
    }


    override fun onClick(comic: ComicShared) {
        mBinding.root.showSnackbar("Comic seleccionado ${comic.title}")

        val stringModel = Gson().toJson(comic)

        val action = ComicFragmentDirections.actionComicFragmentToComicInfoFragment(stringModel)
        Navigation.findNavController(mBinding.root).navigate(action)
    }
}