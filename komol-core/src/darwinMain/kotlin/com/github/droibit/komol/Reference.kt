package com.github.droibit.komol

import kotlin.native.concurrent.AtomicReference

internal actual class Reference<T> actual constructor(initialValue: T) {
    actual var value: T
        get() = ref.value
        set(value) {
            ref.value = value
        }

    private val ref = AtomicReference(initialValue)
}
