package com.github.repo.presentation.users.detailed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.github.repo.domain.GetUserProfileWithReposUseCase
import com.github.repo.presentation.base.BaseViewModel
import com.github.repo.presentation.users.detailed.repos.UserRepositoriesUIModel
import com.github.repo.presentation.utils.asyncValue
import com.github.repo.presentation.utils.getOrThrow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val getUserProfileWithRepos: GetUserProfileWithReposUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _userProfile = MutableLiveData<UserProfileUIModel>()
    val userProfile: LiveData<UserProfileUIModel> = _userProfile

    private val _userRepos = MutableLiveData<List<UserRepositoriesUIModel>>()
    val userRepos: LiveData<List<UserRepositoriesUIModel>> = _userRepos

    init {
        getUserWithRepos(savedStateHandle.getOrThrow("userName"))
    }

    private fun getUserWithRepos(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getUserProfileWithRepos.execute(userName).collect {
                _userProfile.asyncValue = it.profile.toUIModel()
                _userRepos.asyncValue = it.repos.map { repo -> repo.toUIModel() }
            }
        }
    }
}
