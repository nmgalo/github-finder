package com.github.repo.presentation.users.detailed

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.github.repo.R
import com.github.repo.databinding.FragmentUserProfileBinding
import com.github.repo.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserProfileFragment : BaseFragment<UserProfileViewModel>(R.layout.fragment_user_profile) {

    override val viewModel: UserProfileViewModel by viewModels()

    private val args: UserProfileFragmentArgs by navArgs()

    private val adapter = UserRepositoriesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentUserProfileBinding.bind(view).onViewBind()
    }

    private fun FragmentUserProfileBinding.onViewBind() {

        list.layoutManager = LinearLayoutManager(context)
        list.adapter = adapter

        viewModel.getProfile(args.userName)
        viewModel.getRepos(args.userName)

        viewModel.userRepos.observe(viewLifecycleOwner, adapter::submitList)
        viewModel.userProfile.observe(viewLifecycleOwner, {
            Glide.with(root)
                .load(it.avatarURL)
                .circleCrop()
                .into(userProfileImageView)

            followersCountTextView.text = it.followers.toString()
            followingCountTextView.text = it.following.toString()
            publicReposCountTextView.text = it.publicRepos.toString()

        })
    }

}
