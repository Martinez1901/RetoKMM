package com.droal.marvel.network.service

import com.droal.marvel.network.ServiceFactory
import com.example.domain.model.dto.ComicDataWrapperDto
import com.example.utilities.Constants.COMICS
import io.ktor.client.request.get

class ComicsEndPoints(
    private val client: ServiceFactory
) {

    suspend fun allComics() : ComicDataWrapperDto =
        client.getClient(COMICS).get()

}