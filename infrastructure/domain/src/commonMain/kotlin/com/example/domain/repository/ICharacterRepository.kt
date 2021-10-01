package com.example.domain.repository

import com.example.domain.model.Character
import com.example.retokmm.util.Response

interface ICharacterRepository  {

    suspend fun getAllCharactersFromDB(): List<Character>

    suspend fun clearDatabase()

    suspend fun insertCharactersInDB(characters: List<Character>)

    suspend fun getAllCharactersFromNetwork(): Response<List<Character>>
}