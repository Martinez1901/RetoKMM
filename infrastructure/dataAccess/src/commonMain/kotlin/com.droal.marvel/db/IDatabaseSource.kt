package com.droal.marvel.db

import com.example.domain.model.Character
import droal.shareddb.SelectAllCharacters

interface IDatabaseSource {
    suspend fun clearDatabase()
    suspend fun insertCharactersInDB(characters: List<Character>)
    suspend fun getAllCharacters(): List<SelectAllCharacters>
}