// ktlint-disable filename
package com.github.droibit.komol

internal fun createLogMessage(message: String?, throwable: Throwable?): String? {
    var fullMessage = message
    if (fullMessage.isNullOrEmpty()) {
        fullMessage = throwable?.stackTraceToString()
            ?: return null
    } else {
        throwable?.stackTraceToString()?.let {
            fullMessage += "\n$it"
        }
    }
    return fullMessage
}
