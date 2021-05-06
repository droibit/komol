package com.github.droibit.komol

import kotlin.native.concurrent.AtomicReference
import kotlin.native.concurrent.freeze

internal actual class Reference<T> actual constructor(initialValue: T) {
    actual var value: T
        get() = ref.value
        set(value) {
            ref.value = value.freeze()
        }

    private val ref = AtomicReference(initialValue.freeze())
}
