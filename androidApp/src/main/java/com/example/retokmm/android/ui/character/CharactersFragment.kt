package com.example.retokmm.android.ui.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.retokmm.android.core.showSnackbar
import com.example.retokmm.android.databinding.FragmentCharactersBinding
import com.example.retokmm.model.CharacterShared
import com.example.retokmm.util.Resource
import com.example.retokmm.util.Status
import com.example.retokmm.viewModel.*
import com.google.gson.Gson


class CharactersFragment : Fragment(), ClickCharacter {

    private lateinit var mBinding: FragmentCharactersBinding
    private lateinit var charactersViewModel: CharactersViewModel
    private lateinit var charactersListObserver: (state: Resource<List<CharacterShared>>) -> Unit


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = FragmentCharactersBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        charactersViewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)
        charactersViewModel.getInformation(false)

        listener()
    }

    private fun listener() {
        charactersListObserver = {
            getCharacterListState(charactersViewModel.characters.value)
        }
        charactersViewModel.characters.addObserver(charactersListObserver)
    }

    private fun getCharacterListState(result: Resource<List<CharacterShared>>) {
        when (result.status) {
            Status.SUCCESS -> {
                mBinding.progressBar.isVisible = false
                result.data?.let {
                    mBinding.recyclerViewCharacters.adapter = CharactersAdapter(it, this)
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
        charactersViewModel.characters.removeObserver { charactersListObserver }
    }

    override fun onClick(character: CharacterShared) {
        mBinding.root.showSnackbar("Personaje ${character.name} seleccionado")

        val stringModel = Gson().toJson(character)

        val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterInfoFragment(stringModel)
        Navigation.findNavController(mBinding.root).navigate(action)
    }

}