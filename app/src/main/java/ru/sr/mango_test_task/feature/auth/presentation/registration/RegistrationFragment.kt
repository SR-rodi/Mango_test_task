package ru.sr.mango_test_task.feature.auth.presentation.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import ru.sr.mango_test_task.databinding.FragmentRegistrationBinding
import ru.sr.mango_test_task.core.base.BaseFragment

class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {

    private val viewModel by lazy { initViewModel<RegistrationViewModel>() }

    override fun initBinding(inflater: LayoutInflater) =
        FragmentRegistrationBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel
    }
}