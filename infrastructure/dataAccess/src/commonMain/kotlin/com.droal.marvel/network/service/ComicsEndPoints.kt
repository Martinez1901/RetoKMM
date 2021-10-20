package com.droal.marvel.network.service

import com.droal.marvel.network.ServiceFactory
import com.example.domain.model.dto.ComicDataWrapperDto
import com.example.utilities.Constants.COMICS
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ComicsEndPoints(
    private val client: ServiceFactory
) {

    suspend fun allComics() : ComicDataWrapperDto =
        client.getClient(COMICS).get()

    suspend fun searchComicByTitle(comicTitle: String): ComicDataWrapperDto =
        client.getClient(COMICS).get{
            parameter("titleStartsWith",comicTitle)
        }

}