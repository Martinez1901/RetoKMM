package com.example.retokmm.android.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retokmm.android.core.showSnackbar
import com.example.retokmm.android.ui.character.CharactersAdapter
import com.example.retokmm.android.ui.character.ClickCharacter
import com.example.retokmm.android.ui.comic.ComicAdapter
import com.example.retokmm.model.CharacterShared
import com.example.retokmm.model.ComicShared
import com.example.retokmm.util.Resource
import com.example.retokmm.util.Status
import com.example.retokmm.viewModel.CharactersViewModel
import com.example.retokmm.viewModel.ComicsViewModel


class SearchCharacterFragment : SearchContentFragment(), ClickCharacter {

    private lateinit var charactersViewModel: CharactersViewModel
    private lateinit var charactersObserver: (state: Resource<List<CharacterShared>>) -> Unit
    private val adapter = CharactersAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.recyclerViewSearch.layoutManager = LinearLayoutManager(context)
        mBinding.recyclerViewSearch.adapter = adapter
        charactersViewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)
        listener()
        mBinding.progressBar.isVisible = false
    }

    override fun listener() {
        charactersObserver = {
            getDataListState(charactersViewModel.characters.value)
        }
        charactersViewModel.characters.addObserver(charactersObserver)
    }

    override fun clickSearch(name: String) {
        if (name.isEmpty()) {
            mBinding.root.showSnackbar("Favor ingresa el nombre de un character.")
        } else {
            adapter.submitList(emptyList())
            charactersViewModel.searchCharacter(name)
        }
    }

    override fun <T> getDataListState(result: Resource<List<T>>) {
        when (result.status) {
            Status.SUCCESS -> {
                mBinding.progressBar.isVisible = false
                if (result.data.isNullOrEmpty()) {
                    mBinding.root.showSnackbar("Character no encontrado")
                } else {
                    result.data!!.filterIsInstance<CharacterShared>().apply {
                        adapter.submitList(this)
                    }
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
        charactersViewModel.characters.removeObserver { charactersObserver }
    }

    override fun onClick(character: CharacterShared) {
        mBinding.root.showSnackbar("Character seleccionado ${character.name}")
    }
}