package com.github.repo.domain

import com.github.repo.domain.users.UsersRepository
import javax.inject.Inject

class SearchUsersUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    operator fun invoke(keyword: String) = usersRepository.search(keyword)
}
