package com.github.droibit.komol.timber

import com.github.droibit.komol.Komol
import timber.log.Timber

class TimberLogger(
    private val tree: Timber.Tree = Timber.DebugTree()
) : Komol.Loggable {
    override fun log(priority: Komol.LogPriority, message: String?, throwable: Throwable?) {
        tree.log(priority.rawValue, throwable, message)
    }
}
