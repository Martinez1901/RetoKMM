package com.example.domain.useCase

import com.example.domain.model.Character
import com.example.domain.repository.ICharacterRepository
import com.example.retokmm.util.Response

class GetAllCharactersUseCase(
    private val repository: ICharacterRepository) {


    @Throws(Exception::class)
    suspend fun getAllCharacters(updateData: Boolean): Response<List<Character>> {
        val charactersDB = repository.getAllCharactersFromDB()

        return if (charactersDB.isNotEmpty() && !updateData) {
            Response.Success(charactersDB)
        } else {
            getAllCharactersNetwork()
        }
    }

    @Throws(Exception::class)
    private suspend fun getAllCharactersNetwork(): Response<List<Character>>{
        val response: Response<List<Character>> = repository.getAllCharactersFromNetwork()
        repository.clearDatabase()

        if (response is Response.Success){
            repository.insertCharactersInDB(response.data)
        }
        return response
    }

}