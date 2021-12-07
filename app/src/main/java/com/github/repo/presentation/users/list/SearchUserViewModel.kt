package com.github.repo.presentation.users.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.repo.data.users.model.UserItemDTO
import com.github.repo.domain.SearchUsersUseCase
import com.github.repo.presentation.base.BaseViewModel
import com.github.repo.presentation.utils.asyncValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchUserViewModel @Inject constructor(
    private val searchUsersUseCase: SearchUsersUseCase
) : BaseViewModel() {

    private val _searchedItems = MutableLiveData<List<UsersUIModel>>()
    val searchedItems: LiveData<List<UsersUIModel>> = _searchedItems

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    suspend fun search(searchedText: CharSequence) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            searchUsersUseCase(searchedText.toString()).collect {
                _searchedItems.asyncValue = it.map { users -> users.toUIModel() }
            }
            _isLoading.postValue(false)
        }
    }

    private fun UserItemDTO.toUIModel() = UsersUIModel(
        userName = this.login,
        imageURL = this.avatarURL
    ) {
        SearchUsersFragmentDirections
            .actionSearchUsersFragmentToUserProfileFragment(this.login)
            .navigate()
    }
}
