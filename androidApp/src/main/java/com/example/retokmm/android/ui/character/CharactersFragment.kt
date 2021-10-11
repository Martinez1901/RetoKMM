package com.example.retokmm.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.domain.model.Character
import com.example.retokmm.android.core.showSnackbar
import com.example.retokmm.android.databinding.FragmentCharactersBinding
import com.example.retokmm.android.ui.character.CharactersAdapter
import com.example.retokmm.android.ui.character.ClickCharcter
import com.example.retokmm.viewModel.*
import com.example.utilities.Response
import com.google.gson.Gson


class CharactersFragment : Fragment(), ClickCharcter {

    private lateinit var mBinding: FragmentCharactersBinding
    private lateinit var charactersListViewModel: CharactersListViewModel
    private lateinit var charactersListObserver: (state: CharactersListState) -> Unit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = FragmentCharactersBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        charactersListViewModel = ViewModelProvider(this).get(CharactersListViewModel::class.java)
        charactersListViewModel.getInformation()

        listener()
    }

    private fun listener() {
        charactersListObserver = {
            getCharacterListState(charactersListViewModel.getCharactersLiveData.value)
        }
        charactersListViewModel.getCharactersLiveData.addObserver(charactersListObserver)
    }

    fun getCharacterListState(state: CharactersListState) {
        when (state) {
            is SuccessGetCharacterListState -> {
                mBinding.progressBar.isVisible = false
                val response = state.response as Response.Success
                //onSuccessGetGitHubList(response.data)
                val data = response.data
                mBinding.recyclerViewCharacters.adapter = CharactersAdapter(data, this)
            }

            is LoadingGetCharacterListState -> {
                mBinding.progressBar.isVisible = true
            }

            is ErrorGetCharacterListState -> {
                mBinding.progressBar.isVisible = false
                val response = state.response as Response.Error
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        charactersListViewModel.getCharactersLiveData.removeObserver { charactersListObserver }
    }

    override fun onClick(character: Character) {
        mBinding.root.showSnackbar("Personaje ${character.name} seleccionado")
        val id = character.id

        val stringModel = Gson().toJson(character)

        /*val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterInfoFragment(character)
        Navigation.findNavController(mBinding.root).navigate(action)*/
    }

}