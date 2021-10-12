package com.example.retokmm.model

data class ComicShared(
    val id: Int,
    val digitalId: Int,
    val title: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    val thumbnailPath: String
)