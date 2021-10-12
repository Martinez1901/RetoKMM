package com.example.domain.repository

import com.example.domain.model.ComicDomain
import com.example.utilities.Response

interface IComicsRepository  {

    suspend fun getAllComicsFromDB(): List<ComicDomain>

    suspend fun clearDatabase()

    suspend fun insertComicInDB(comics: List<ComicDomain>)

    suspend fun getAllComicsFromNetwork(): Response<List<ComicDomain>>
}