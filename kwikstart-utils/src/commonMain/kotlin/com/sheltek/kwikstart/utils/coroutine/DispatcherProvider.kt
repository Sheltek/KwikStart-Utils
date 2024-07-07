package com.sheltek.kwikstart.utils.coroutine

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val Default: CoroutineDispatcher
    val IO: CoroutineDispatcher
    val Main: CoroutineDispatcher
    val Unconfined: CoroutineDispatcher
}
