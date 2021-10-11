package com.example.domain.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class ThumbnailDto(
    val path: String,
    val extension: String
)