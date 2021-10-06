package com.example.domain.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDataContainerDto(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharacterDto>
)