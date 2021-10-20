package com.example.domain.model.dto

import com.example.domain.https
import com.example.domain.model.CharacterDomain
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class CharacterDto(
    val id: Int,
    val name: String,
    val description: String?,
    val modified: String?,
    val resourceURI: String?,
    val thumbnail: ThumbnailDto,
    @Transient
    val urls: String = "",
    @Transient
    val comics: String = "",
    @Transient
    val stories: String = "",
    @Transient
    val events: String = "",
    @Transient
    val series: String = "",
)

// Conversion de la respuesta a objeto CharacterDomain
fun CharacterDto.toCharacter(): CharacterDomain {
    return CharacterDomain(
        id = id,
        name = name,
        description = description,
        modified = modified,
        resourceURI = resourceURI?.https(),
        //Acá se construye el path de la miniatura
        thumbnailPath = thumbnail.path.https() + "." + thumbnail.extension,
        urls = urls,
        comics = comics,
        stories = stories,
        events = events,
        series = series
    )
}
