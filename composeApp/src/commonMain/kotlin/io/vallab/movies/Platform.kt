package io.vallab.movies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform