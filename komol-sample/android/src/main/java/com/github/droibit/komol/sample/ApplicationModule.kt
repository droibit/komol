package com.github.droibit.komol.sample

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import com.github.droibit.komol.Komol
import com.github.droibit.komol.timber.TimberLogger

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