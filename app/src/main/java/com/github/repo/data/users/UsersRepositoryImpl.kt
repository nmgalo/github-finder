package com.github.repo.data.users

import com.github.repo.data.ApiService
import com.github.repo.data.repos.UserRepositoriesDTO
import com.github.repo.data.users.model.UserItemDTO
import com.github.repo.data.users.model.UserProfileDTO
import com.github.repo.domain.users.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UsersRepository {
    override fun search(keyword: String): Flow<List<UserItemDTO>> = flow {
        emit(apiService.searchUsers(keyword).items)
    }

    override fun getProfile(login: String): Flow<UserProfileDTO> = flow {
        emit(apiService.getUserProfile(login))
    }

    override fun getUserRepositories(userName: String): Flow<List<UserRepositoriesDTO>> = flow {
        emit(apiService.getUserRepos(userName))
    }
}
