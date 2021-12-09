package com.github.repo.presentation.users.detailed

data class UserProfileUIModel(
    val avatarURL: String,
    val name: String?,
    val company: String?,
    val publicRepos: Int,
    val followers: Int,
    val following: Int,
)
