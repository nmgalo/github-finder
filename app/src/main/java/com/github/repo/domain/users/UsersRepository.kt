package com.github.repo.domain.users

import com.github.repo.data.repos.UserRepositoriesDTO
import com.github.repo.data.users.model.UserItemDTO
import com.github.repo.data.users.model.UserProfileDTO
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun search(keyword: String): Flow<List<UserItemDTO>>
    fun getProfile(login: String): Flow<UserProfileDTO>
    fun getUserRepositories(userName: String): Flow<List<UserRepositoriesDTO>>
}
