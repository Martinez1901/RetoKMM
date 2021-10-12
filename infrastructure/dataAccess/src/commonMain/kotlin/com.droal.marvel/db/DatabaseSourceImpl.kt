package com.droal.marvel.db

import com.example.domain.model.CharacterDomain
import com.example.domain.model.ComicDomain
import droal.shareddb.SelectAllCharacters
import droal.shareddb.SelectAllComics

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

    override suspend fun insertComicsInDB(comics: List<ComicDomain>) {
        database?.insertComics(comics)
    }

    override suspend fun getAllComics(): List<SelectAllComics> {
        return database?.getAllComics() ?: emptyList()
    }
}