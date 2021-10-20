package com.example.retokmm.util

import com.example.domain.model.CharacterDomain
import com.example.domain.model.ComicDomain
import com.example.retokmm.model.CharacterShared
import com.example.retokmm.model.ComicShared

fun CharacterDomain.fromDomainToView(): CharacterShared =
    CharacterShared(
        id = this.id,
        name = this.name,
        description = this.description ?: "",
        modified = this.modified ?: "",
        resourceURI = this.resourceURI ?: "",
        thumbnailPath = this.thumbnailPath,
        urls = this.urls,
        comics = this.comics,
        stories = this.stories,
        events = this.events,
        series = this.series,
    )

fun List<CharacterDomain>.fromListDomainToListView(): List<CharacterShared> =
    this.map { it.fromDomainToView() }

fun ComicDomain.fromDomainToView(): ComicShared =
    ComicShared(
        id = this.id,
        digitalId = this.digitalId,
        title = this.title,
        description = this.description ?: "",
        modified = this.modified ?: "",
        resourceURI = this.resourceURI ?: "",
        thumbnailPath = this.thumbnailPath,
        pageCount = this.pageCount
    )

fun List<ComicDomain>.fromListDomainComicToListView(): List<ComicShared> =
    this.map { it.fromDomainToView() }