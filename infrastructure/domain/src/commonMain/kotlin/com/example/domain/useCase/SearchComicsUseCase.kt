package com.example.domain.useCase

import com.example.domain.model.ComicDomain
import com.example.domain.repository.IComicsRepository
import com.example.utilities.Response

class SearchComicsUseCase(
    private val repository: IComicsRepository
) {
    suspend fun getAllComicsByTitle(comicTitle: String): Response<List<ComicDomain>> {
        val comicsDB = repository.getComicsByTitle(comicTitle)
        return Response.Success(comicsDB)
    }
}