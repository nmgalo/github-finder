package com.github.repo.presentation.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.debounce

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
fun EditText.textChanges(debounceTimeOut: Long = 800) = callbackFlow {
    val watcher = addTextChangedListener {
        offer(it ?: "")
    }
    awaitClose { removeTextChangedListener(watcher) }
}.debounce(debounceTimeOut)
