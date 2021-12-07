package com.github.repo.presentation

import com.bumptech.glide.Glide
import com.github.repo.databinding.UserItemBinding

data class UsersUIModel(
    val userName: String,
    val imageURL: String,
    val onClick: () -> Unit
) {
    infix fun bindTo(binding: UserItemBinding) {
        binding.userName.text = userName
        binding.root.setOnClickListener { onClick.invoke() }
        Glide.with(binding.root)
            .load(imageURL)
            .circleCrop()
            .into(binding.userImageView)
    }
}
