package com.github.repo.presentation.users.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.repo.R
import com.github.repo.databinding.UserItemBinding
import com.github.repo.presentation.utils.inflate

class UsersRecyclerAdapter :
    ListAdapter<UsersUIModel, UsersRecyclerAdapter.ViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position) bindTo UserItemBinding.bind(holder.itemView)
    }

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.user_item))

    class DiffUtilCallback : DiffUtil.ItemCallback<UsersUIModel>() {
        override fun areItemsTheSame(oldItem: UsersUIModel, newItem: UsersUIModel) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: UsersUIModel, newItem: UsersUIModel) =
            oldItem.userName == newItem.userName

    }
}
