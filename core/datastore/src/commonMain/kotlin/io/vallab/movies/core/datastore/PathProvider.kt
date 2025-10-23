package io.vallab.movies.core.datastore

import okio.Path

expect class PathProvider {

    fun getPath(fileName: String): Path
}
