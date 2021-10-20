package com.droal.marvel.db.entity

import com.example.domain.model.CharacterDomain
import com.example.domain.model.ComicDomain
import droal.shareddb.SearchCharacterByTitle
import droal.shareddb.SearchComicsByTitle
import droal.shareddb.SelectAllCharacters

fun SelectAllCharacters.toCharacter(): CharacterDomain {
    return CharacterDomain(
        id = id.toInt(),
        name = name,
        description = description,
        modified = modified,
        resourceURI = resourceURI,
        thumbnailPath = path,
        urls = "",
        comics = "",
        stories = "",
        events = "",
        series = ""
    )
}

fun SearchCharacterByTitle.toCharacter() : CharacterDomain {
    return CharacterDomain(
        id = id.toInt(),
        name = name,
        description = description,
        modified = modified,
        resourceURI = resourceURI,
        thumbnailPath = path,
        urls = "",
        comics = "",
        stories = "",
        events = "",
        series = ""
    )
}


