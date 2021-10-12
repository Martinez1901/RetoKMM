package com.example.retokmm.android.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.retokmm.android.R
import com.example.retokmm.android.databinding.FragmentSearchContentBinding


class SearchContentFragment : Fragment() {

    private lateinit var mBinding: FragmentSearchContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSearchContentBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.btnSearch.setOnClickListener {
            mBinding.progressBar.isVisible = true
        }
    }
}