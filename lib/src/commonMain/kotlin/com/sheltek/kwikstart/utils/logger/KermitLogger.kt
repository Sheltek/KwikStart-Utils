package com.sheltek.kwikstart.utils.logger

import co.touchlab.kermit.Logger
import com.sheltek.kwikstart.core.logger.LoggingManager

class KermitLogger(private val loggingEnabled: Boolean) : LoggingManager {

    override fun d(tag: String?, message: String?, t: Throwable?) {
        if (loggingEnabled) {
            tag?.let {
                Logger.d(throwable = t, tag = tag, messageString = message.orEmpty())
            } ?: Logger.d(throwable = t) { message.orEmpty() }
        }
    }

    override fun e(tag: String?, message: String?, t: Throwable?) {
        if (loggingEnabled) {
            tag?.let {
                Logger.e(throwable = t, tag = tag, messageString = message.orEmpty())
            } ?: Logger.e(throwable = t) { message.orEmpty() }
        }
    }

    override fun i(tag: String?, message: String?, t: Throwable?) {
        if (loggingEnabled) {
            tag?.let {
                Logger.i(throwable = t, tag = tag, messageString = message.orEmpty())
            } ?: Logger.i(throwable = t) { message.orEmpty() }
        }
    }

    override fun v(tag: String?, message: String?, t: Throwable?) {
        if (loggingEnabled) {
            tag?.let {
                Logger.v(throwable = t, tag = tag, messageString = message.orEmpty())
            } ?: Logger.v(throwable = t) { message.orEmpty() }
        }
    }

    override fun w(tag: String?, message: String?, t: Throwable?) {
        if (loggingEnabled) {
            tag?.let {
                Logger.w(throwable = t, tag = tag, messageString = message.orEmpty())
            } ?: Logger.w(throwable = t, messageString = message.orEmpty())
        }
    }

    override fun wtf(tag: String?, message: String?, t: Throwable?) {
        tag?.let {
            Logger.d(throwable = t, tag = tag, messageString = message.orEmpty())
        } ?: Logger.d(throwable = t) { message.orEmpty() }
    }
}
