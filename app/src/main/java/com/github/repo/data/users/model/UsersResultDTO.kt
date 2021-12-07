package com.github.repo.data.users.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsersResultDTO(
    @SerialName("total_count")
    val totalCount: Int,
    val items: List<UserItemDTO>
)