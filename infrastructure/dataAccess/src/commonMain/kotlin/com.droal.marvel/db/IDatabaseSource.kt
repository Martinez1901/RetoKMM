package com.droal.marvel.db

import com.example.domain.model.CharacterDomain
import droal.shareddb.SelectAllCharacters

interface IDatabaseSource {
    suspend fun clearDatabase()
    suspend fun insertCharactersInDB(characters: List<CharacterDomain>)
    suspend fun getAllCharacters(): List<SelectAllCharacters>
}