package com.droal.marvel.db

import com.example.domain.model.CharacterDomain
import com.example.domain.model.ComicDomain
import com.squareup.sqldelight.db.SqlDriver
import droal.shareddb.MarvelDatabase
import droal.shareddb.SelectAllCharacters
import droal.shareddb.SelectAllComics

class Database(sqlDriver: SqlDriver) {

    private val database = MarvelDatabase(sqlDriver)
    private val dbQuery = database.marvelDatabaseQueries

    fun clearDatabase(){
        dbQuery.transaction {
            dbQuery.removeAllThumbnail()
            dbQuery.removeAllCharacters()
        }
    }

    fun getAllCharacters(): List<SelectAllCharacters> {
        return dbQuery.selectAllCharacters().executeAsList()
    }

    fun insertCharacters(characters: List<CharacterDomain>){
        dbQuery.transaction {
            characters.forEach { character ->
                dbQuery.insertCharacter(
                    id = character.id.toString(),
                    name= character.name,
                    description= character.description,
                    modified= character.modified,
                    resourceURI= character.resourceURI,
                    thumbnailId=character.id.toString()
                )
                dbQuery.insertThumbnail(
                    idThumb= character.id.toString(),
                    path= character.thumbnailPath
                )
            }
        }
    }

    fun getAllComics(): List<SelectAllComics> {
        return dbQuery.selectAllComics().executeAsList()
    }

    fun insertComics(comics: List<ComicDomain>){
        dbQuery.transaction {
            comics.forEach { comic ->
                dbQuery.insertComic(
                    id = comic.id.toLong(),
                    digitalId = comic.digitalId.toLong(),
                    title= comic.title,
                    description= comic.description,
                    modified= comic.modified,
                    resourceURI= comic.resourceURI,
                    thumbnailId=comic.id.toString()
                )
                dbQuery.insertThumbnail(
                    idThumb= comic.id.toString(),
                    path= comic.thumbnailPath
                )
            }
        }
    }

}