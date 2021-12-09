package com.github.repo.domain

import com.github.repo.data.repos.UserRepositoriesDTO
import com.github.repo.data.users.model.UserProfileDTO

data class UserProfileDomainModel(
    val profile: UserProfileDTO,
    val repos: List<UserRepositoriesDTO>
)
