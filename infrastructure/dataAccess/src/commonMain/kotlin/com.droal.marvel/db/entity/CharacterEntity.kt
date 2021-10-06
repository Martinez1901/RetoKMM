package com.droal.marvel.db.entity

import com.example.domain.model.Character
import droal.shareddb.SelectAllCharacters

fun SelectAllCharacters.toCharacter(): Character {
    return Character(
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
