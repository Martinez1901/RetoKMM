package com.droal.marvel.db.entity

import com.example.domain.model.CharacterDomain
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
