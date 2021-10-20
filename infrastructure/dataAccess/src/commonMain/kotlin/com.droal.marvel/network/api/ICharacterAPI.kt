package com.droal.marvel.network.api

import com.example.domain.model.CharacterDomain
import com.example.utilities.Response

interface ICharacterAPI {

    suspend fun getCharacters(): Response<List<CharacterDomain>>
    suspend fun searchCharacterByTitle(characterTitle: String): Response<List<CharacterDomain>>
}