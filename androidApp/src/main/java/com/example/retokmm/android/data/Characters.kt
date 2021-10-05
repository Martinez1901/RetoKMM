package com.example.retokmm.android.data

data class Characters(
    val available: Int = 0,
    val collectionURI: String = "",
    val items: List<Any> = emptyList(),
    val returned: Int = 0
)