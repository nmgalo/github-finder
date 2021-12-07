package com.github.repo.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.repo.presentation.base.navigation.NavigationCommand

abstract class BaseFragment<viewModel : BaseViewModel>(@LayoutRes layout: Int) : Fragment(layout) {

    abstract val viewModel: viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.navigationCommands.observe(viewLifecycleOwner, {
            when (val command = it) {
                is NavigationCommand.To -> {
                    findNavController().navigate(command.directions)
                }
                is NavigationCommand.Back -> {
                    findNavController().popBackStack()
                }
            }
        })
    }
}
