package com.droal.marvel.network.api

import com.droal.marvel.network.service.CharacterEndPoints
import com.example.domain.model.Character
import com.example.domain.model.dto.CharacterDataWrapperDto
import com.example.domain.model.dto.toCharacter
import com.example.retokmm.util.Response

class CharacterAPIImpl(
    private val characterEndPoints: CharacterEndPoints
) : ICharacterAPI {

    override suspend fun getCharacters(): Response<List<Character>> {

        val response: CharacterDataWrapperDto = characterEndPoints.allCharacters()
        val container = response.data
        val characters = container?.results
        return if (characters != null) {
            Response.Success(characters.map{it.toCharacter()})
        }else{
            Response.Success(emptyList())
        }
    }

}