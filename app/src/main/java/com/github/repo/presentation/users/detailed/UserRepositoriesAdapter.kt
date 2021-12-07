package com.github.repo.presentation.users.detailed

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.repo.R
import com.github.repo.databinding.RepoItemBinding
import com.github.repo.presentation.users.detailed.repos.UserRepositoriesUIModel
import com.github.repo.presentation.utils.inflate


class UserRepositoriesAdapter :
    ListAdapter<UserRepositoriesUIModel, UserRepositoriesAdapter.ViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position) bindTo RepoItemBinding.bind(holder.itemView)
    }

    class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.repo_item))

    class DiffUtilCallback : DiffUtil.ItemCallback<UserRepositoriesUIModel>() {
        override fun areItemsTheSame(
            oldItem: UserRepositoriesUIModel,
            newItem: UserRepositoriesUIModel
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: UserRepositoriesUIModel,
            newItem: UserRepositoriesUIModel
        ) = oldItem.id == newItem.id

    }
}
