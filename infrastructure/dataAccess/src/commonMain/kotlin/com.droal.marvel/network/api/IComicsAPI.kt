package com.droal.marvel.network.api

import com.example.domain.model.ComicDomain
import com.example.utilities.Response

interface IComicsAPI {

    suspend fun getComics(): Response<List<ComicDomain>>
    suspend fun searchComicsByTitle(comicTitle: String): Response<List<ComicDomain>>
}