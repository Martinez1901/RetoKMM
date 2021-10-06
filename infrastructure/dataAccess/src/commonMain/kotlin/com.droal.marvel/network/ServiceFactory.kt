package com.droal.marvel.network

import com.example.retokmm.util.Constants
import com.example.retokmm.util.Constants.BASE_URL
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
            parameter("apikey", Constants.API_KEY)
            parameter("ts", Constants.TS)
            parameter("hash", Constants.HASH)
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