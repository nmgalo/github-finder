package com.github.repo.presentation.users.detailed.repos

import com.github.repo.databinding.RepoItemBinding

data class UserRepositoriesUIModel(
    val id: Int,
    val fullName: String,
    val description: String?,
    val language: String?
) {
    infix fun bindTo(binding: RepoItemBinding) {
        binding.repoNameTextView.text = fullName
        binding.repoLanguageTextView.text = language
    }
}
