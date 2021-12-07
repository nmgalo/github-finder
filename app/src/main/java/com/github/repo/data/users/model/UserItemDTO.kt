package com.github.repo.data.users.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserItemDTO(
    val login: String,
    val id: Long,
    @SerialName("avatar_url")
    val avatarURL: String,
)
