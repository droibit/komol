package com.github.droibit.komol

internal expect class Reference<T>(initialValue: T) {
    var value: T
}