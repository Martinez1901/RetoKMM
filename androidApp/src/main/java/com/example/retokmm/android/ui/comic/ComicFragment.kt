package com.example.retokmm.android.ui.comic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retokmm.Greeting
import com.example.retokmm.android.Character
import com.example.retokmm.android.databinding.FragmentComicBinding
import com.scotiabank.bootcamp.squad3.digitalsbc.core.showSnackbar


class ComicFragment : Fragment(), ClickComic {

    private lateinit var mBinding: FragmentComicBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentComicBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvHome.text = greet()

        mBinding.recyclerViewComic.adapter = ComicAdapter(listComics(), this)

    }

    fun listComics(): List<Character> {
        return listOf(
            Character(1, "Superman", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b/portrait_uncanny.jpg"),
            Character(2, "Spider Man", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b/portrait_uncanny.jpg"),
            Character(3, "Iron Man", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b/portrait_uncanny.jpg"),
            Character(4, "Acuaman", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b/portrait_uncanny.jpg"),
            Character(5, "Hulk", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b/portrait_uncanny.jpg"),
            Character(6, "Capitan America", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b/portrait_uncanny.jpg"),
        )
    }

    fun greet(): String {
        return Greeting().greetingHome()
    }

    override fun onClick(character: Character) {
        mBinding.root.showSnackbar("Comic seleccionado ${character.name}")
    }
}