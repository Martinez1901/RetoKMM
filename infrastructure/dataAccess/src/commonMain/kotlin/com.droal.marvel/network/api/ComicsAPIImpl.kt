package com.droal.marvel.network.api

import com.droal.marvel.network.service.ComicsEndPoints
import com.example.domain.model.ComicDomain
import com.example.domain.model.dto.ComicDataWrapperDto
import com.example.domain.model.dto.toComic
import com.example.utilities.Response

class ComicsAPIImpl(
    private val comicsEndPoints: ComicsEndPoints
) : IComicsAPI {

    override suspend fun getComics(): Response<List<ComicDomain>> {

        val response: ComicDataWrapperDto = comicsEndPoints.allComics()
        val container = response.data
        val comics = container?.results
        return if (comics != null) {
            Response.Success(comics.map { it.toComic()})
        }else{
            Response.Success(emptyList())
        }
    }

}