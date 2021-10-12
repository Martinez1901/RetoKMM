package com.example.domain.model.dto

import com.example.domain.https
import com.example.domain.model.ComicDomain
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class ComicDto(
    val id: Int,
    val digitalId: Int,
    val title: String,
    val description: String?,
    val modified: String?,
    val resourceURI: String?,
    val thumbnail: ThumbnailDto
)

fun ComicDto.toComic(): ComicDomain {
    return ComicDomain(
        id = id,
        digitalId = digitalId,
        title = title,
        modified = modified,
        description = description,
        resourceURI = resourceURI?.https(),
        //Acá se construye el path de la miniatura
        thumbnailPath = thumbnail.path.https() + "." + thumbnail.extension
    )
}
