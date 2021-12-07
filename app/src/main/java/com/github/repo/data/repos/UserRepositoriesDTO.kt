package com.github.repo.data.repos

import com.github.repo.presentation.users.detailed.repos.UserRepositoriesUIModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRepositoriesDTO(
    val id: Int,
    @SerialName("full_name")
    val fullName: String,
    val description: String?,
    val language: String?
) {
    fun toUIModel() = UserRepositoriesUIModel(
        id = this.id,
        fullName = this.fullName,
        description = this.description,
        language = this.language
    )
}
