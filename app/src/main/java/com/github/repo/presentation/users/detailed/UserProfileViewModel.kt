package com.github.repo.presentation.users.detailed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.repo.domain.GetRepositoriesUseCase
import com.github.repo.domain.GetUserProfileUseCase
import com.github.repo.presentation.base.BaseViewModel
import com.github.repo.presentation.users.detailed.repos.UserRepositoriesUIModel
import com.github.repo.presentation.utils.asyncValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val getRepositoriesUseCase: GetRepositoriesUseCase
) : BaseViewModel() {

    private val _userProfile = MutableLiveData<UserProfileUIModel>()
    val userProfile: LiveData<UserProfileUIModel> = _userProfile

    private val _userRepos = MutableLiveData<List<UserRepositoriesUIModel>>()
    val userRepos: LiveData<List<UserRepositoriesUIModel>> = _userRepos

    fun getProfile(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getUserProfileUseCase(userName).collect {
                _userProfile.asyncValue = it.toUIModel()
            }
        }
    }

    fun getRepos(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getRepositoriesUseCase(userName).collect {
                _userRepos.asyncValue = it.map { repos -> repos.toUIModel() }
            }
        }
    }

}
