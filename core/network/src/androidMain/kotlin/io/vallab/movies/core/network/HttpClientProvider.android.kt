package io.vallab.movies.core.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import java.util.concurrent.TimeUnit

actual class HttpClientProvider {

    actual fun getHttpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient(OkHttp) {
        config(this)

        engine {
            config {
                retryOnConnectionFailure(true)
                connectTimeout(0, TimeUnit.SECONDS)
            }
        }
    }

}
