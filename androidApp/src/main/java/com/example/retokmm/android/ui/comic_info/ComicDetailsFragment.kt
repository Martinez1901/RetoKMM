package com.example.retokmm.android.ui.comic_info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retokmm.android.R
import com.example.retokmm.android.databinding.FragmentComicDetailsBinding

private const val ARG_DETAIL = "detail"

class ComicDetailsFragment : Fragment() {

    private lateinit var mBinding: FragmentComicDetailsBinding

    private var detail: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            detail = it.getString(ARG_DETAIL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentComicDetailsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvDetails.text = detail
    }

    companion object {
        @JvmStatic
        fun newInstance(detail: String) =
            ComicDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DETAIL, detail)
                }
            }
    }
}