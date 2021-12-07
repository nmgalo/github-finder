package com.github.repo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.repo.data.ApiService
import com.github.repo.presentation.utils.asyncValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchUserViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private val _searchedItems = MutableLiveData<List<UsersUIModel>>()
    val searchedItems: LiveData<List<UsersUIModel>> = _searchedItems

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    suspend fun search(searchedText: CharSequence) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            _searchedItems.asyncValue =
                apiService.searchUsers(searchedText.toString()).items.map { it.toUIModel() }
            _isLoading.postValue(false)
        }
    }
}
