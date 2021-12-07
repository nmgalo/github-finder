package com.github.repo.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.repo.R
import com.github.repo.databinding.FragmentSearchUsersBinding
import com.github.repo.presentation.utils.textChanges
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SearchUsersFragment : Fragment(R.layout.fragment_search_users) {

    private val viewModel: SearchUserViewModel by viewModels()

    private val adapter = UsersRecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentSearchUsersBinding.bind(view).onViewBind()
    }

    private fun FragmentSearchUsersBinding.onViewBind() {
        usersList.layoutManager = LinearLayoutManager(context)
        usersList.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.searchedItems.observe(viewLifecycleOwner, adapter::submitList)
            search.textChanges().collect(viewModel::search)
        }

        viewModel.isLoading.observe(viewLifecycleOwner, {
            loader.visibility = if (it) View.VISIBLE else View.GONE
        })
    }
}
