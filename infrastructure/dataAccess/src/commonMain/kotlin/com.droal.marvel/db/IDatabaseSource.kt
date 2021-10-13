package com.droal.marvel.db

import com.example.domain.model.CharacterDomain
import com.example.domain.model.ComicDomain
import droal.shareddb.SearchComicsByTitle
import droal.shareddb.SelectAllCharacters
import droal.shareddb.SelectAllComics

interface IDatabaseSource {
    suspend fun clearDatabase()

    //Characters
    suspend fun insertCharactersInDB(characters: List<CharacterDomain>)
    suspend fun getAllCharacters(): List<SelectAllCharacters>

    //Comics
    suspend fun insertComicsInDB(comics: List<ComicDomain>)
    suspend fun getAllComics(): List<SelectAllComics>
    suspend fun searchComicsByTitle(comicTitle: String): List<SearchComicsByTitle>
}