package com.example.retokmm.android.ui.comic_info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retokmm.android.R
import com.example.retokmm.android.databinding.FragmentComicCreatorBinding
import com.example.retokmm.model.ComicShared
import com.google.gson.Gson


private const val ARG_COMIC = "comicString"


class ComicCreatorFragment : Fragment() {
    private var comicString: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            comicString = it.getString(ARG_COMIC)
        }
    }

    private lateinit var mBinding: FragmentComicCreatorBinding
    private lateinit var mComic: ComicShared

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentComicCreatorBinding.inflate(inflater, container, false)
        mComic = Gson().fromJson(comicString, ComicShared::class.java)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvExample.text = "Page Count = ${mComic.pageCount}"
    }

    companion object {
        fun newInstance(comic: String) =
            ComicCreatorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_COMIC, comic)
                }
            }
    }
}