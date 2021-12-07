package com.github.repo.domain

import com.github.repo.domain.users.UsersRepository
import javax.inject.Inject

class GetUserProfileUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    operator fun invoke(login: String) = usersRepository.getProfile(login)
}
