package com.github.repo.presentation.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.github.repo.presentation.base.navigation.NavigationCommand
import com.github.repo.presentation.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val navigationCommands = SingleLiveEvent<NavigationCommand>()

    fun NavDirections.navigate() {
        navigationCommands.postValue(NavigationCommand.To(this))
    }

    fun back() {
        navigationCommands.postValue(NavigationCommand.Back)
    }
}
