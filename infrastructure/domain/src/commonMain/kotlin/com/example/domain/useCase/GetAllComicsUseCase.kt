package com.example.domain.useCase

import com.example.domain.model.ComicDomain
import com.example.domain.repository.IComicsRepository
import com.example.utilities.Response

class GetAllComicsUseCase(
    private val repository: IComicsRepository
) {

    @Throws(Exception::class)
    suspend fun getAllComics(updateData: Boolean): Response<List<ComicDomain>> {
        val charactersDB = repository.getAllComicsFromDB()

        return if (charactersDB.isNotEmpty() && !updateData)
            Response.Success(charactersDB)
        else
            getAllComicsNetwork()
    }

    private suspend fun getAllComicsNetwork(): Response<List<ComicDomain>> {
        val response: Response<List<ComicDomain>> = repository.getAllComicsFromNetwork()
        repository.clearDatabase()

        if (response is Response.Success){
            repository.insertComicInDB(response.data)
        }
        return response
    }

}