package com.github.droibit.komol

import kotlin.native.concurrent.freeze
import platform.Foundation.NSError

fun Komol.v(error: NSError, message: String? = null) {
    Komol.v(error.toThrowable(), message)
}

fun Komol.d(error: NSError, message: String? = null) {
    Komol.d(error.toThrowable(), message)
}

fun Komol.i(error: NSError, message: String? = null) {
    Komol.i(error.toThrowable(), message)
}

fun Komol.w(error: NSError, message: String? = null) {
    Komol.w(error.toThrowable(), message)
}

fun Komol.e(error: NSError, message: String? = null) {
    Komol.e(error.toThrowable(), message)
}

fun Komol.wtf(error: NSError, message: String? = null) {
    Komol.wtf(error.toThrowable(), message)
}

private fun NSError.toThrowable(): Throwable {
    return Throwable("$localizedDescription($code)")
        .freeze()
}
