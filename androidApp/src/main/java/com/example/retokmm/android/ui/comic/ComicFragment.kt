package com.example.retokmm.android.ui.comic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.retokmm.Greeting
import com.example.retokmm.android.Character
import com.example.retokmm.android.databinding.FragmentComicBinding
import com.example.retokmm.android.core.showSnackbar


class ComicFragment : Fragment(), ClickComic {

    private lateinit var mBinding: FragmentComicBinding
    private val comicViewModel: ComicViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentComicBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvHome.text = greet()

        comicViewModel.onCreate()

        comicViewModel.isLoading.observe(requireActivity(), {
            mBinding.progressBar.isVisible = it
        })

        comicViewModel.listComics.observe(requireActivity(), {
            mBinding.recyclerViewComic.adapter = ComicAdapter(it, this)
        })

    }

    fun greet(): String {
        return Greeting().greetingHome()
    }

    override fun onClick(character: Character) {
        mBinding.root.showSnackbar("Comic seleccionado ${character.name}")
        val action = ComicFragmentDirections.actionComicFragmentToComicInfoFragment(character)
        Navigation.findNavController(mBinding.root).navigate(action)
    }
}