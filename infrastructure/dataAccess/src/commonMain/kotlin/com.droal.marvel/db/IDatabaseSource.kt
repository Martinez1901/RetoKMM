package com.droal.marvel.db

import com.example.domain.model.CharacterDomain
import com.example.domain.model.ComicDomain
import droal.shareddb.SearchCharacterByTitle
import droal.shareddb.SearchComicsByTitle
import droal.shareddb.SelectAllCharacters
import droal.shareddb.SelectAllComics

interface IDatabaseSource {

    //Characters
    suspend fun clearAllCharacters()
    suspend fun insertCharactersInDB(characters: List<CharacterDomain>)
    suspend fun getAllCharacters(): List<SelectAllCharacters>
    suspend fun searchCharacterByTitle(characterTitle: String): List<SearchCharacterByTitle>

    //Comics
    suspend fun clearAllComics()
    suspend fun insertComicsInDB(comics: List<ComicDomain>)
    suspend fun getAllComics(): List<SelectAllComics>
    suspend fun searchComicsByTitle(comicTitle: String): List<SearchComicsByTitle>
}