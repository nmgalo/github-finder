package com.github.repo.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetUserProfileWithReposUseCase @Inject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val getRepositoriesUseCase: GetRepositoriesUseCase
) {
    fun execute(userName: String): Flow<UserProfileDomainModel> {
        return getUserProfileUseCase(userName).combine(getRepositoriesUseCase(userName)) { profile, repos ->
            UserProfileDomainModel(
                profile = profile,
                repos = repos
            )
        }
    }
}
