package ru.sr.mango_test_task.feature.auth.presentation.confirmation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import ru.sr.mango_test_task.databinding.FragmentConfirmationCodeBinding
import ru.sr.mango_test_task.core.base.BaseFragment
import ru.sr.mango_test_task.core.extension.setFormatMask
import ru.sr.mango_test_task.core.extension.setMask
import ru.sr.mango_test_task.core.extension.toStringWithoutMask
import ru.sr.mango_test_task.feature.auth.presentation.confirmation.model.ConfirmationViewAction
import ru.sr.mango_test_task.feature.auth.presentation.confirmation.model.ConfirmationViewState

class ConfirmationCodeFragment : BaseFragment<FragmentConfirmationCodeBinding>() {

    private val viewModel by lazy { initViewModel<ConfirmationCodeViewModel>() }
    private val args by navArgs<ConfirmationCodeFragmentArgs>()

    override fun initBinding(inflater: LayoutInflater) =
        FragmentConfirmationCodeBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startSettings()
        onAuthClickButton()
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }
        flowObserver(viewModel.viewAction()) { action -> actionObserver(action) }
    }

    private fun actionObserver(action: ConfirmationViewAction?) {
        when (action) {
            ConfirmationViewAction.NavigationOnProfile ->
                navigation(
                    ConfirmationCodeFragmentDirections
                        .actionConfirmationCodeFragmentToProfileFragment()
                )

            ConfirmationViewAction.NavigationOnRegistration ->
                navigation(
                    ConfirmationCodeFragmentDirections
                        .actionConfirmationCodeFragmentToRegistrationFragment(args.phone)
                )

            null -> {}
        }
    }

    private fun stateObserver(state: ConfirmationViewState) {
        errorCodeState(state.ErrorMessageField)
        loadState(state.isLoading)
        binding.errorNetwork.error.isVisible = state.isNetworkError
    }

    private fun errorCodeState(isCodeFieldError: String?) {
        binding.authCodeLayout.error = isCodeFieldError
    }

    private fun loadState(isLoading: Boolean) = binding.apply {
        authCodeLayout.isEnabled = !isLoading
        authButton.isEnabled = !isLoading
        progressBar.isVisible = isLoading
    }

    private fun onAuthClickButton() = binding.authButton.setOnClickListener {
        viewModel.checkCode(args.phone, binding.authCode.toStringWithoutMask())
    }

    private fun startSettings(format: String = "XX-XX-XX") = binding.apply {
        authCode.setFormatMask(format)
        authCodeLayout.hint = format
        authCode.setMask()
    }
}