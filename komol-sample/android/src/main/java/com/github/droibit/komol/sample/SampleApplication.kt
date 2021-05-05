package com.github.droibit.komol.sample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import com.github.droibit.komol.Komol
import com.github.droibit.komol.sample.shared.SampleException

@HiltAndroidApp
class SampleApplication : Application() {

    @Inject
    fun bootstrap(logger: Komol.Loggable) {
        Komol.initialize(logger)
        Komol.i("Bootstrapped!!")
    }
}