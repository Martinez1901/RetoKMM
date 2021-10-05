package com.example.retokmm.android.data

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)