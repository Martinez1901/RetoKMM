package com.droal.marvel.network.service

import com.droal.marvel.network.ServiceFactory
import com.example.domain.model.dto.CharacterDataWrapperDto
import com.example.utilities.Constants.CHARACTERS
import io.ktor.client.request.get

class CharacterEndPoints(
    private val client: ServiceFactory
) {

    suspend fun allCharacters() : CharacterDataWrapperDto =
        client.getClient(CHARACTERS).get()

}