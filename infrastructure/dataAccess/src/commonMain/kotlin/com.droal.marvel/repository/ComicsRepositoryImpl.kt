package com.droal.marvel.repository

import com.droal.marvel.db.IDatabaseSource
import com.droal.marvel.db.entity.toComic
import com.droal.marvel.network.api.IComicsAPI
import com.example.domain.model.ComicDomain
import com.example.domain.repository.IComicsRepository
import com.example.utilities.Response

class ComicsRepositoryImpl (
    private val dbDataSource: IDatabaseSource,
    private val comicsApi: IComicsAPI
): IComicsRepository {

    override suspend fun getAllComicsFromDB(): List<ComicDomain> {
        return dbDataSource.getAllComics().map { it.toComic() }
    }

    override suspend fun clearAllCharacters() {
        dbDataSource.clearAllCharacters()
    }

    override suspend fun clearAllComics() {
        dbDataSource.clearAllComics()
    }

    override suspend fun insertComicInDB(comics: List<ComicDomain>) {
        dbDataSource.insertComicsInDB(comics)
    }

    override suspend fun getAllComicsFromNetwork(): Response<List<ComicDomain>> {
       return comicsApi.getComics()
    }
}