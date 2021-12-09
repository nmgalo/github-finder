package com.github.repo.presentation.utils

import androidx.lifecycle.SavedStateHandle

fun <T> SavedStateHandle.getOrThrow(key: String): T = this.get<T>(key) ?: error("[$key] not found")
