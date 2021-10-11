package com.droal.marvel.repository

import com.droal.marvel.db.IDatabaseSource
import com.droal.marvel.db.entity.toCharacter
import com.droal.marvel.network.api.ICharacterAPI
import com.example.domain.model.CharacterDomain
import com.example.domain.repository.ICharacterRepository
import com.example.utilities.Response

class CharacterRepositoryImpl (
    private val dbDataSource: IDatabaseSource,
    private val characterApi: ICharacterAPI
): ICharacterRepository {

    override suspend fun getAllCharactersFromDB(): List<CharacterDomain> {
        return dbDataSource.getAllCharacters().map { it.toCharacter() }
    }

    override suspend fun clearDatabase() {
        dbDataSource.clearDatabase()
    }

    override suspend fun insertCharactersInDB(characters: List<CharacterDomain>) {
        dbDataSource.insertCharactersInDB(characters)
    }

    override suspend fun getAllCharactersFromNetwork(): Response<List<CharacterDomain>> {
       return characterApi.getCharacters()
    }
}