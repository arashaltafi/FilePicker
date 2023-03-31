package com.arash.altafi.filepicker.sample3.utils.helper.state

import androidx.lifecycle.LifecycleOwner

interface ObservableState<T> {
    fun set(value: T)
    fun get(): T
    fun observe(owner: LifecycleOwner, observer: (T) -> Unit)
    fun observeForever(observer: (T) -> Unit)
}