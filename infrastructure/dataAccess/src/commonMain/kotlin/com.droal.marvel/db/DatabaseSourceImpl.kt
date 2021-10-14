package com.droal.marvel.db

import com.example.domain.model.CharacterDomain
import com.example.domain.model.ComicDomain
import droal.shareddb.SearchComicsByTitle
import droal.shareddb.SelectAllCharacters
import droal.shareddb.SelectAllComics

class DatabaseSourceImpl(private val database: Database?) : IDatabaseSource {

    override suspend fun clearAllCharacters() {
        database?.clearAllCharacters()
    }

    override suspend fun clearAllComics() {
        database?.clearAllComics()
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

    override suspend fun searchComicsByTitle(comicTitle: String): List<SearchComicsByTitle> {
        return database?.searchComicsByTitle(comicTitle) ?: emptyList()
    }
}