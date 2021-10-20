package com.example.retokmm.android.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.retokmm.android.core.showSnackbar
import com.example.retokmm.android.databinding.FragmentSearchContentBinding
import com.example.retokmm.util.Resource


abstract class SearchContentFragment : Fragment() {

    open lateinit var mBinding: FragmentSearchContentBinding

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
        mBinding.btnSearch.setOnClickListener {
            clickSearch(mBinding.tieSearch.text.toString())
        }
    }

    abstract fun listener()

    abstract fun <T> getDataListState(result: Resource<List<T>>)

    abstract fun clickSearch(name: String)
}