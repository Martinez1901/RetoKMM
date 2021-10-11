package com.example.domain.useCase

import com.example.domain.model.Character
import com.example.domain.repository.ICharacterRepository
import com.example.utilities.Response

class GetAllCharactersUseCase(
    private val repository: ICharacterRepository) {


    @Throws(Exception::class)
    suspend fun getAllCharacters(updateData: Boolean): Response<List<Character>> {
       return getAllCharactersNetwork()
    }

    private suspend fun getAllCharactersNetwork(): Response<List<Character>> {
        val response: Response<List<Character>> = repository.getAllCharactersFromNetwork()
        //repository.clearDatabase()

        if (response is Response.Success){
            //repository.insertCharactersInDB(response.data)
        }
        return response
    }

}