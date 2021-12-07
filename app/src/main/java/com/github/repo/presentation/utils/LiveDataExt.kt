package com.github.repo.presentation.utils

import androidx.lifecycle.MutableLiveData

var <T> MutableLiveData<T>.asyncValue: T?
    get() = value
    set(value) {
        postValue(value)
    }

