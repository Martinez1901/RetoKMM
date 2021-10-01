package com.example.retokmm.android.ui.comic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retokmm.android.Character
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ComicViewModel: ViewModel() {

    val listComics = MutableLiveData<List<Character>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            delay(1000)
            listComics.postValue(listComics())
            isLoading.postValue(false)
        }
    }

    fun listComics(): List<Character> {
        return listOf(
            Character(1, "Superman", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b"),
            Character(2, "Spider Man", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b"),
            Character(3, "Iron Man", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b"),
            Character(4, "Acuaman", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b"),
            Character(5, "Hulk", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b"),
            Character(6, "Capitan America", thumbnailPath = "http://i.annihil.us/u/prod/marvel/i/mg/d/03/6151f9130899b"),
        )
    }
}