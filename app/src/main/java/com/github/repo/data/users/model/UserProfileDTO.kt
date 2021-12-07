package com.github.repo.data.users.model

import com.github.repo.presentation.users.detailed.UserProfileUIModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfileDTO(
    @SerialName("avatar_url")
    val avatarURL: String,
    val name: String,
    val company: String?,
    @SerialName("public_repos")
    val publicRepos: Int,
    val followers: Int,
    val following: Int,
) {

    fun toUIModel() = UserProfileUIModel(
        avatarURL = this.avatarURL,
        name = this.name,
        company = this.company,
        publicRepos = this.publicRepos,
        followers = this.followers,
        following = this.following
    )

}
