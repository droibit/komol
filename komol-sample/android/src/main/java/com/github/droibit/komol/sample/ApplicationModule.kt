package com.github.droibit.komol.sample

import com.github.droibit.komol.Komol
import com.github.droibit.komol.timber.TimberLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Named("debuggable")
    @Provides
    fun provideDebuggable(): Boolean = BuildConfig.DEBUG

    @Provides
    fun provideLogger(@Named("debuggable") debuggable: Boolean): Komol.Loggable {
        return if (debuggable) TimberLogger() else Komol.Loggable { _, _, _ ->
        }
    }
}
