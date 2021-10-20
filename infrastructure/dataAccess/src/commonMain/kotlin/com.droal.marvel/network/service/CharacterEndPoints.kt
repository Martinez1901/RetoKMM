package com.droal.marvel.network.service

import com.droal.marvel.network.ServiceFactory
import com.example.domain.model.dto.CharacterDataWrapperDto
import com.example.utilities.Constants.CHARACTERS
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class CharacterEndPoints(
    private val client: ServiceFactory
) {

    suspend fun allCharacters() : CharacterDataWrapperDto =
        client.getClient(CHARACTERS).get()

    suspend fun searchCharacterByTitle(characterTitle: String): CharacterDataWrapperDto =
        client.getClient(CHARACTERS).get{
            parameter("nameStartsWith",characterTitle)
        }
}