package com.github.droibit.komol

import com.github.droibit.komol.Komol.LogPriority.ASSERT
import com.github.droibit.komol.Komol.LogPriority.DEBUG
import com.github.droibit.komol.Komol.LogPriority.ERROR
import com.github.droibit.komol.Komol.LogPriority.INFO
import com.github.droibit.komol.Komol.LogPriority.VERBOSE
import com.github.droibit.komol.Komol.LogPriority.WARNING
import com.github.droibit.komol.TestRecorder.Log
import com.github.droibit.komol.TestRecorder.TestThrowable
import kotlin.test.BeforeTest
import kotlin.test.Test

class KomolTest {

    @BeforeTest
    fun setUp() {
        // Clear all loggers
        Komol.initialize()
    }

    @Test
    fun testVerboseLogs() {
        val recorder = TestRecorder()
        Komol.initialize(recorder)

        Komol.v("verbose")
        Komol.v(TestThrowable("error!"), null)
        Komol.v(TestThrowable("error!!"), "verbose")

        recorder.assertValueHistory(
            Log(VERBOSE, "verbose"),
            Log(VERBOSE, null, TestThrowable("error!")),
            Log(VERBOSE, "verbose", TestThrowable("error!!"))
        )
    }

    @Test
    fun testDebugLogs() {
        val recorder = TestRecorder()
        Komol.initialize(recorder)

        Komol.d("debug")
        Komol.d(TestThrowable("error!"), null)
        Komol.d(TestThrowable("error!!"), "debug")

        recorder.assertValueHistory(
            Log(DEBUG, "debug"),
            Log(DEBUG, null, TestThrowable("error!")),
            Log(DEBUG, "debug", TestThrowable("error!!")),
        )
    }

    @Test
    fun testInfoLogs() {
        val recorder = TestRecorder()
        Komol.initialize(recorder)

        Komol.i("info")
        Komol.i(TestThrowable("error!"), null)
        Komol.i(TestThrowable("error!!"), "info")

        recorder.assertValueHistory(
            Log(INFO, "info"),
            Log(INFO, null, TestThrowable("error!")),
            Log(INFO, "info", TestThrowable("error!!")),
        )
    }

    @Test
    fun testWarningLogs() {
        val recorder = TestRecorder()
        Komol.initialize(recorder)

        Komol.w("warning")
        Komol.w(TestThrowable("error!"), null)
        Komol.w(TestThrowable("error!!"), "warning")

        recorder.assertValueHistory(
            Log(WARNING, "warning"),
            Log(WARNING, null, TestThrowable("error!")),
            Log(WARNING, "warning", TestThrowable("error!!")),
        )
    }

    @Test
    fun testErrorLogs() {
        val recorder = TestRecorder()
        Komol.initialize(recorder)

        Komol.e("error")
        Komol.e(TestThrowable("error!"), null)
        Komol.e(TestThrowable("error!!"), "error")

        recorder.assertValueHistory(
            Log(ERROR, "error"),
            Log(ERROR, null, TestThrowable("error!")),
            Log(ERROR, "error", TestThrowable("error!!")),
        )
    }

    @Test
    fun testAssertLogs() {
        val recorder = TestRecorder()
        Komol.initialize(recorder)

        Komol.wtf("assert")
        Komol.wtf(TestThrowable("error!"), null)
        Komol.wtf(TestThrowable("error!!"), "assert")

        recorder.assertValueHistory(
            Log(ASSERT, "assert"),
            Log(ASSERT, null, TestThrowable("error!")),
            Log(ASSERT, "assert", TestThrowable("error!!")),
        )
    }
}