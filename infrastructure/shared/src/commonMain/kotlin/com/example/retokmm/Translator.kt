package com.example.retokmm

import com.example.domain.model.CharacterDomain
import com.example.retokmm.model.CharacterShared

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