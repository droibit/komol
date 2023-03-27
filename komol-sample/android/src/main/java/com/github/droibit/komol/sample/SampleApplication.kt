package com.github.droibit.komol.sample

import android.app.Application
import com.github.droibit.komol.Komol
import com.github.droibit.komol.timber.TimberLogger

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val logger = if (BuildConfig.DEBUG) TimberLogger() else Komol.Loggable { _, _, _ -> }
        Komol.initialize(logger)
        Komol.i("Bootstrapped!!")
    }
}
