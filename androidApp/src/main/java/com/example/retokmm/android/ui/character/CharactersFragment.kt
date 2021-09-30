package com.example.retokmm.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retokmm.Greeting
import com.example.retokmm.android.databinding.FragmentCharactersBinding
import com.example.retokmm.android.ui.character.CharactersAdapter
import com.example.retokmm.android.ui.character.ClickCharcter
import com.scotiabank.bootcamp.squad3.digitalsbc.core.showSnackbar


class CharactersFragment : Fragment(), ClickCharcter {

    private lateinit var mBinding: FragmentCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentCharactersBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.tv1.text = Greeting().greetingCharacter()

        mBinding.recyclerViewCharacters.adapter = CharactersAdapter(listCharacters(), this)

    }

    fun listCharacters(): List<Character> {
        return listOf(
            Character(1, "Superman", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/standard_fantastic.jpg"),
            Character(2, "Spider Man", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/standard_fantastic.jpg"),
            Character(3, "Iron Man", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/standard_fantastic.jpg"),
            Character(4, "Acuaman", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/standard_fantastic.jpg"),
            Character(5, "Hulk", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/standard_fantastic.jpg"),
            Character(6, "Capitan America", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/standard_fantastic.jpg"),
        )
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
)