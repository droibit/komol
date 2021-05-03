package com.github.droibit.komol

object Komol {
    private val loggersRef = Reference<List<Loggable>>(listOf())

    fun initialize(vararg loggers: Loggable) {
        this.loggersRef.value = loggers.toList()
    }

    fun v(message: String) {
        loggersRef.value.forEach { it.log(LogPriority.VERBOSE, message, null) }
    }

    fun v(throwable: Throwable, message: String? = null) {
        loggersRef.value.forEach { it.log(LogPriority.VERBOSE, message, throwable) }
    }

    fun d(message: String) {
        loggersRef.value.forEach { it.log(LogPriority.DEBUG, message, null) }
    }

    fun d(throwable: Throwable, message: String? = null) {
        loggersRef.value.forEach { it.log(LogPriority.DEBUG, message, throwable) }
    }

    fun i(message: String) {
        loggersRef.value.forEach { it.log(LogPriority.INFO, message, null) }
    }

    fun i(throwable: Throwable, message: String? = null) {
        loggersRef.value.forEach { it.log(LogPriority.INFO, message, throwable) }
    }

    fun w(message: String) {
        loggersRef.value.forEach { it.log(LogPriority.WARNING, message, null) }
    }

    fun w(throwable: Throwable, message: String? = null) {
        loggersRef.value.forEach { it.log(LogPriority.WARNING, message, throwable) }
    }

    fun e(message: String) {
        loggersRef.value.forEach { it.log(LogPriority.ERROR, message, null) }
    }

    fun e(throwable: Throwable, message: String? = null) {
        loggersRef.value.forEach { it.log(LogPriority.ERROR, message, throwable) }
    }

    fun wtf(throwable: Throwable, message: String? = null) {
        loggersRef.value.forEach { it.log(LogPriority.ASSERT, message, throwable) }
    }

    fun wtf(message: String) {
        loggersRef.value.forEach { it.log(LogPriority.ASSERT, message, null) }
    }

    enum class LogPriority(val rawValue: Int) {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARNING(5),
        ERROR(6),
        ASSERT(7),
    }

    fun interface Loggable {
        fun log(priority: Komol.LogPriority, message: String?, throwable: Throwable?)
    }
}