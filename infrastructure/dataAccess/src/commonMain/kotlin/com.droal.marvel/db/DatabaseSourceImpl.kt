package com.droal.marvel.db

import com.example.domain.model.Character
import droal.shareddb.SelectAllCharacters

class DatabaseSourceImpl(private val database: Database?): IDatabaseSource {


    override suspend fun clearDatabase() {
        database?.clearDatabase()
    }

    override suspend fun insertCharactersInDB(characters: List<Character>) {
        database?.insertCharacters(characters)
    }

    override suspend fun getAllCharacters(): List<SelectAllCharacters> {
        return database?.getAllCharacters() ?: emptyList()
    }
}