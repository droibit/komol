package com.github.droibit.komol.timber

import com.github.droibit.komol.Komol
import timber.log.Timber

class TimberLogger(
    private val tree: Timber.Tree = KomolDebugTree()
) : Komol.Loggable {
    override fun log(priority: Komol.LogPriority, message: String?, throwable: Throwable?) {
        tree.log(priority.rawValue, throwable, message)
    }
}

// TODO: Consider a better solution than outputting the caller's class as a tag.
private class KomolDebugTree : Timber.DebugTree() {
    private val fqcnIgnore = listOf(
        Timber::class.java.name,
        Timber.Forest::class.java.name,
        Timber.Tree::class.java.name,
        Timber.DebugTree::class.java.name,
        Komol::class.java.name,
        TimberLogger::class.java.name,
        KomolDebugTree::class.java.name
    )

    override fun createStackElementTag(element: StackTraceElement): String? {
        val newElement = Throwable().stackTrace
            .first { it.className !in fqcnIgnore }
        return super.createStackElementTag(newElement)
    }
}