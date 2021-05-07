package com.github.droibit.komol

import kotlin.native.concurrent.freeze
import platform.Foundation.NSCalendar
import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSGregorianCalendar
import platform.Foundation.NSLocale

class PrintLogger(
    private val tag: String = "Komol"
) : Komol.Loggable {

    private val dateFormatter = NSDateFormatter().apply {
        calendar = NSCalendar(calendarIdentifier = NSGregorianCalendar)
        locale = NSLocale(localeIdentifier = "en_US_POSIX")
        dateFormat = "yyyy-MM-dd HH:mm:ss.SSS"
    }

    private val tagPrefixes = mapOf(
        Komol.LogPriority.VERBOSE to "V",
        Komol.LogPriority.DEBUG to "D",
        Komol.LogPriority.INFO to "I",
        Komol.LogPriority.WARNING to "W",
        Komol.LogPriority.ERROR to "E",
        Komol.LogPriority.ASSERT to "A"
    )

    init {
        freeze()
    }

    override fun log(priority: Komol.LogPriority, message: String?, throwable: Throwable?) {
        val fullMessage = createLogMessage(message, throwable)
            ?: return
        val currentDate = dateFormatter.stringFromDate(NSDate())
        println("$currentDate ${tagPrefixes[priority]}/$tag: $fullMessage")
    }
}
