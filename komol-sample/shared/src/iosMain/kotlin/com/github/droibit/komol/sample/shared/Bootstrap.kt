package com.github.droibit.komol.sample.shared

import com.github.droibit.komol.Komol
import com.github.droibit.komol.PrintLogger

fun bootstrap(debuggable: Boolean) {
    if (debuggable) {
        Komol.initialize(PrintLogger())
    }
    Komol.d("Bootstrapped!!")
}

// TODO: Export `Komol` as Shared.framework.
fun exportKomol(): Komol = Komol