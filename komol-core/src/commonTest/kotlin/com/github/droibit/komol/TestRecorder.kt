package com.github.droibit.komol

import kotlin.test.assertContentEquals

class TestRecorder : Komol.Loggable {
    // Use Reference<T> avoid InvalidMutabilityException on Kotlin/Native.
    private val historiesRef = Reference<List<Log>>(listOf())

    fun assertValueHistory(vararg logs: Log) {
        assertContentEquals(
            historiesRef.value,
            logs.toList()
        )
    }

    override fun log(priority: Komol.LogPriority, message: String?, throwable: Throwable?) {
        val newLogs = historiesRef.value.toMutableList()
        newLogs.add(Log(priority, message, throwable))
        historiesRef.value = newLogs
    }

    data class Log(
        val priority: Komol.LogPriority,
        val message: String? = null,
        val throwable: Throwable? = null
    )

    data class TestThrowable(override val message: String) : Throwable(message)
}
