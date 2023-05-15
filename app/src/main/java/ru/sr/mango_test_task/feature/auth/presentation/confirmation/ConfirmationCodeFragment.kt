package ru.sr.mango_test_task.feature.auth.presentation.confirmation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.navArgs
import ru.sr.mango_test_task.databinding.FragmentConfirmationCodeBinding
import ru.sr.mango_test_task.presentations.auth.confirmation.ConfirmationCodeFragmentArgs
import ru.sr.mango_test_task.core.base.BaseFragment

class ConfirmationCodeFragment : BaseFragment<FragmentConfirmationCodeBinding>() {

    private val viewModel by lazy { initViewModel<ConfirmationCodeViewModel>() }
    private val args by navArgs<ConfirmationCodeFragmentArgs>()

    override fun initBinding(inflater: LayoutInflater) =
        FragmentConfirmationCodeBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.authButton.setOnClickListener {
            viewModel.checkCode(args.phone, "133337")
        }
    }
}