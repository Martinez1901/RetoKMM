package com.example.retokmm.viewModel

import com.example.domain.model.Character
import com.example.utilities.Response

sealed class CharactersListState {
    abstract val response: Response<List<Character>>?
}

data class SuccessGetCharacterListState(override val response: Response<List<Character>>) : CharactersListState()
data class LoadingGetCharacterListState(override val response: Response<List<Character>>? = null) : CharactersListState()
data class ErrorGetCharacterListState(override val response: Response<List<Character>>) : CharactersListState()