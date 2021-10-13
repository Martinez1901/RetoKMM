package com.example.domain.repository

import com.example.domain.model.CharacterDomain
import com.example.utilities.Response

interface ICharacterRepository  {

    suspend fun getAllCharactersFromDB(): List<CharacterDomain>

    suspend fun clearAllCharacters()

    suspend fun clearAllComics()

    suspend fun insertCharactersInDB(characters: List<CharacterDomain>)

    suspend fun getAllCharactersFromNetwork(): Response<List<CharacterDomain>>
}