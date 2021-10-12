package com.example.domain.useCase

import com.example.domain.model.CharacterDomain
import com.example.domain.repository.ICharacterRepository
import com.example.utilities.Response

class GetAllCharactersUseCase(
    private val repository: ICharacterRepository) {


    @Throws(Exception::class)
    suspend fun getAllCharacters(updateData: Boolean): Response<List<CharacterDomain>> {
        val charactersDB = repository.getAllCharactersFromDB()

        return if (charactersDB.isNotEmpty() && !updateData)
            Response.Success(charactersDB)
        else
            getAllCharactersNetwork()
    }

    private suspend fun getAllCharactersNetwork(): Response<List<CharacterDomain>> {
        val response: Response<List<CharacterDomain>> = repository.getAllCharactersFromNetwork()
        repository.clearDatabase()

        if (response is Response.Success){
            repository.insertCharactersInDB(response.data)
        }
        return response
    }

}