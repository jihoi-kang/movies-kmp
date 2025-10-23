package io.vallab.movies

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
            appDeclaration = vallabAppDeclaration {
                androidContext(this@MoviesApplication)
            },
        )
    }

}
