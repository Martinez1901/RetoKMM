package com.example.retokmm.android.ui.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retokmm.android.Character
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CharactersViewModel: ViewModel() {

    val listCharacters = MutableLiveData<List<Character>>()

    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            delay(5000)
            listCharacters.postValue(listCharacters())
            isLoading.postValue(false)
        }
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
}