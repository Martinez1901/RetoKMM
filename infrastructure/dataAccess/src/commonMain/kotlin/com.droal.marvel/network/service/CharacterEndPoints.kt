package com.droal.marvel.network.service

import com.example.domain.model.dto.CharacterDataWrapperDto
import com.example.retokmm.util.Constants.BASE_URL
import com.example.retokmm.util.Constants.CHARACTERS
import io.ktor.client.*
import io.ktor.client.request.get

class CharacterEndPoints(
    private val client: HttpClient
) {

    suspend fun allCharacters() : CharacterDataWrapperDto =
        client.get(BASE_URL + CHARACTERS)

}