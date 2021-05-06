package com.github.droibit.komol.sample

import android.app.Application
import com.github.droibit.komol.Komol
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class SampleApplication : Application() {

    @Inject
    fun bootstrap(logger: Komol.Loggable) {
        Komol.initialize(logger)
        Komol.i("Bootstrapped!!")
    }
}