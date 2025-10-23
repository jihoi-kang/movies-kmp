package io.vallab.movies.core.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import kotlinx.serialization.json.Json

internal class VallabNetworkFactory(
    private val httpClientProvider: HttpClientProvider,
) {

    fun create(): HttpClient = httpClientProvider.getHttpClient {
        install(ContentNegotiation) {
            val json = Json {
                ignoreUnknownKeys = true
                encodeDefaults = true
            }
            register(ContentType.Application.Json, KotlinxSerializationConverter(json))
            register(ContentType.Text.Plain, KotlinxSerializationConverter(json))
        }
        install(Logging) {
            level = LogLevel.ALL
        }
        install(HttpTimeout) {
            connectTimeoutMillis = TIMEOUT_MILLIS
            requestTimeoutMillis = TIMEOUT_MILLIS
            socketTimeoutMillis = TIMEOUT_MILLIS
        }
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(
                        BuildKonfig.TMDB_ACCESS_TOKEN,
                        "",
                    )
                }
            }
        }
        defaultRequest {
            contentType(ContentType.Application.Json)
            url {
                protocol = URLProtocol.HTTPS
                host = BASE_HOST
            }
        }
    }

    companion object Companion {
        private const val TIMEOUT_MILLIS = 6_000L
        private const val BASE_HOST = "api.themoviedb.org"
    }

}
