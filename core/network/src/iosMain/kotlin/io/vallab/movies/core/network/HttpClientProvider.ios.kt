package io.vallab.movies.core.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.darwin.Darwin

actual class HttpClientProvider {

    actual fun getHttpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient(Darwin) {
        config(this)

        engine {
            configureRequest {
                setAllowsCellularAccess(true)
            }
        }
    }

}
