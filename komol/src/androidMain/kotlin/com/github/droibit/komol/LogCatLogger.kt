package com.github.droibit.komol

import android.util.Log

class LogCatLogger(
    private val tag: String = "Komol"
) : Komol.Loggable {
    override fun log(priority: Komol.LogPriority, message: String?, throwable: Throwable?) {
        val fullMessage = createLogMessage(message, throwable)
            ?: return
        if (priority == Komol.LogPriority.ASSERT) {
            Log.wtf(tag, fullMessage)
        } else {
            Log.println(priority.rawValue, tag, fullMessage)
        }
    }
}