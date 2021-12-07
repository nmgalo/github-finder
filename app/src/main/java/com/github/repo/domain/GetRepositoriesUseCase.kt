package com.github.repo.domain

import com.github.repo.domain.users.UsersRepository
import javax.inject.Inject

class GetRepositoriesUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    operator fun invoke(userName: String) = usersRepository.getUserRepositories(userName)
}
