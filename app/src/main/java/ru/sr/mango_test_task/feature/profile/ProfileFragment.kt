package ru.sr.mango_test_task.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import ru.sr.mango_test_task.core.base.BaseFragment
import ru.sr.mango_test_task.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentProfileBinding.inflate(inflater)

    private val viewModel by lazy { initViewModel<ProfileViewModel>() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser()

    }
}