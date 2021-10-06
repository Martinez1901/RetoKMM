package com.droal.marvel.network.api

import com.example.domain.model.Character
import com.example.retokmm.util.Response

interface ICharacterAPI {

    suspend fun getCharacters(): Response<List<Character>>
}