package com.example.domain.useCase

import com.example.domain.model.CharacterDomain
import com.example.domain.repository.ICharacterRepository
import com.example.utilities.Response

class SearchCharacterUseCase(
    private val repository: ICharacterRepository) {

    @Throws(Exception::class)
    suspend fun searchCharacter(characterTitle: String): Response<List<CharacterDomain>> {
        val charactersDB = repository.getCharacterByTitleDB(characterTitle)

        return if (charactersDB.isNotEmpty())
            Response.Success(charactersDB)
        else
            repository.getCharacterByTitleFromNetwork(characterTitle)
    }

}