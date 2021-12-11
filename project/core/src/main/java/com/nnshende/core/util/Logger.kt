package com.nnshende.core.util

class Logger(
    private val TAG: String,
    private val isDebug: Boolean = true
) {
    fun log(msg: String) {
        if (!isDebug) {
            // production logging - Crashlytics, etc.
        }
        printLogD(TAG, msg)
    }

    companion object Factory {
        fun buildDebug(TAG: String): Logger {
            return Logger(
                TAG = TAG,
                isDebug = true
            )
        }

        fun buildRelease(TAG: String): Logger {
            return Logger(
                TAG = TAG,
                isDebug = false
            )
        }
    }
}

fun printLogD(TAG: String, message: String) {
    println("$TAG: $message")
}