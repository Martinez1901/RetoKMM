package com.example.domain

fun String.https(): String {
    var url = this
    if (url.contains("http:")){
        val data = url.split("http:")
        url = "https:${data[1]}"
    }
    return url
}