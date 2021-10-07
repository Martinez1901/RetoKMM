package com.droal.marvel.network

import com.example.utilities.Constants
import com.example.utilities.Constants.API_KEY
import com.example.utilities.Constants.BASE_URL
import com.example.utilities.Constants.HASH
import com.example.utilities.Constants.TS
import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import kotlinx.serialization.json.Json
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.parameter
import io.ktor.client.request.url


class ServiceFactory {

    fun getClient(path: String) = HttpClient {
        defaultRequest {
            url("$BASE_URL$path")
            parameter("apikey", API_KEY)
            parameter("ts", TS)
            parameter("hash", HASH)
        }
        install(JsonFeature) {
            val json = Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            }
            serializer = KotlinxSerializer(json)
        }
    }

}