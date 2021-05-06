package com.github.droibit.komol

internal actual class Reference<T> actual constructor(initialValue: T) {
    actual var value: T
        get() = _value
        set(value) {
            _value = value
        }

    private var _value: T = initialValue
}
