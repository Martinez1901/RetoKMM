package com.droal.marvel.db.entity

import com.example.domain.model.ComicDomain
import droal.shareddb.SelectAllComics

fun SelectAllComics.toComic(): ComicDomain {
    return ComicDomain(
        id = id.toInt(),
        digitalId = digitalId.toInt(),
        title = title,
        description = description,
        modified = modified,
        resourceURI = resourceURI,
        thumbnailPath = path,
        pageCount = 0
    )
}


