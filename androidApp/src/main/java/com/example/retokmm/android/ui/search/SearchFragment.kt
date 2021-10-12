package com.example.retokmm.android.ui.search

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.retokmm.android.R
import com.example.retokmm.android.databinding.FragmentSearchBinding
import android.widget.EditText
import androidx.navigation.Navigation


class SearchFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var mBinding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSearchBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //mBinding.tvSearch.text = greet()
        mBinding.imgComics.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToSearchContentFragment("comics")
            Navigation.findNavController(mBinding.root).navigate(action)
        }
        mBinding.imgCharacter.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToSearchContentFragment("character")
            Navigation.findNavController(mBinding.root).navigate(action)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        super.onCreateOptionsMenu(menu, inflater)

        val search = menu.findItem(R.id.menu_search)
        val searchView = search.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)

        val searchEditText =
            searchView!!.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
        searchEditText.setTextColor(resources.getColor(R.color.white))
        searchEditText.setHintTextColor(resources.getColor(R.color.white))
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}