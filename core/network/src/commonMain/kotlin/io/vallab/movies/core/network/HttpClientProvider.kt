package io.vallab.movies.core.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

expect class HttpClientProvider {

    fun getHttpClient(config: HttpClientConfig<*>.() -> Unit) : HttpClient

}
