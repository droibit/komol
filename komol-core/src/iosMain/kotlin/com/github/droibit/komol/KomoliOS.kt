@file:Suppress("unused")

package com.github.droibit.komol

import platform.Foundation.NSError

fun Komol.v(error: NSError, message: String? = null) {
    v(error.toThrowable(), message)
}

fun Komol.d(error: NSError, message: String? = null) {
    d(error.toThrowable(), message)
}

fun Komol.i(error: NSError, message: String? = null) {
    i(error.toThrowable(), message)
}

fun Komol.w(error: NSError, message: String? = null) {
    w(error.toThrowable(), message)
}

fun Komol.e(error: NSError, message: String? = null) {
    e(error.toThrowable(), message)
}

fun Komol.wtf(error: NSError, message: String? = null) {
    wtf(error.toThrowable(), message)
}

private fun NSError.toThrowable(): Throwable {
    return Throwable("$localizedDescription($code)")
}
