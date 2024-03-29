package com.github.droibit.komol.sample.shared

import com.github.droibit.komol.Komol
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.cancellation.CancellationException

class SampleRepository {
    suspend fun getText(): String {
        return withContext(Dispatchers.Default) {
            "Hello, World!".also {
                Komol.d("$it@Kotlin")
            }
        }
    }

    @Throws(SampleException::class, CancellationException::class)
    suspend fun forceError() {
        withContext(Dispatchers.Default) {
            throw SampleException("Force error!!")
        }
    }

    @Throws(SampleException::class, CancellationException::class)
    suspend fun occurError() {
        withContext(Dispatchers.Default) {
            try {
                throw SampleException("Error occurred.")
            } catch (e: Exception) {
                Komol.e(e)
            }
        }
    }
}
