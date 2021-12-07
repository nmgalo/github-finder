package com.github.repo.data.users.model

import kotlinx.serialization.Serializable

@Serializable
data class UsersResultDTO(
    val items: List<UserItemDTO>
)