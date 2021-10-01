package com.example.retokmm.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.retokmm.Greeting
import com.example.retokmm.android.databinding.FragmentCharactersBinding
import com.example.retokmm.android.ui.character.CharactersAdapter
import com.example.retokmm.android.ui.character.CharactersViewModel
import com.example.retokmm.android.ui.character.ClickCharcter
import com.scotiabank.bootcamp.squad3.digitalsbc.core.showSnackbar
import kotlinx.parcelize.Parcelize
import java.io.Serializable


class CharactersFragment : Fragment(), ClickCharcter {

    private lateinit var mBinding: FragmentCharactersBinding
    private val charactersViewModel: CharactersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentCharactersBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        charactersViewModel.onCreate()

        charactersViewModel.isLoading.observe(requireActivity(), {
            mBinding.progressBar.isVisible = it
        })

        charactersViewModel.listCharacters.observe(requireActivity(), {
            mBinding.recyclerViewCharacters.adapter = CharactersAdapter(it, this)
        })

        mBinding.tv1.text = Greeting().greetingCharacter()

    }

    override fun onClick(character: Character) {
        mBinding.root.showSnackbar("Personaje ${character.name} seleccionado")
    }

}


data class Character(
    val id: Int,
    val name: String,
    val description: String? = "",
    val thumbnailPath: String,
): Serializable