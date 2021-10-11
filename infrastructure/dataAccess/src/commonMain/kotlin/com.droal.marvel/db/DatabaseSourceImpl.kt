package com.droal.marvel.db

import com.example.domain.model.CharacterDomain
import droal.shareddb.SelectAllCharacters

class DatabaseSourceImpl(private val database: Database?): IDatabaseSource {


    override suspend fun clearDatabase() {
        database?.clearDatabase()
    }

    override suspend fun insertCharactersInDB(characters: List<CharacterDomain>) {
        database?.insertCharacters(characters)
    }

    override suspend fun getAllCharacters(): List<SelectAllCharacters> {
        return database?.getAllCharacters() ?: emptyList()
    }
}