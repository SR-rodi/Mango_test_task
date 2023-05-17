package ru.sr.mango_test_task.feature.auth.presentation.registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import ru.sr.mango_test_task.databinding.FragmentRegistrationBinding
import ru.sr.mango_test_task.core.base.BaseFragment
import ru.sr.mango_test_task.feature.auth.presentation.registration.model.RegistrationAction
import ru.sr.mango_test_task.feature.auth.presentation.registration.model.RegistrationState

class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>() {

    private val viewModel by lazy { initViewModel<RegistrationViewModel>() }

    private val args by navArgs<RegistrationFragmentArgs>()

    override fun initBinding(inflater: LayoutInflater) =
        FragmentRegistrationBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.phoneNumber.setText(args.phoneNumber)

        flowObserver(viewModel.viewStates()) { state -> stateObserve(state) }
        flowObserver(viewModel.viewAction()) { action -> actionObserver(action) }

        binding.registrationButton.setOnClickListener { onClickRegistration() }


    }

    private fun actionObserver(action: RegistrationAction?) = when (action) {
        RegistrationAction.NavigateProfile ->
            navigation(RegistrationFragmentDirections.actionRegistrationFragmentToProfileFragment())

        null -> {}
    }

    private fun onClickRegistration() = viewModel.userRegistration(
        args.phoneNumber,
        binding.name.text.toString(),
        binding.userName.text.toString()
    )


    private fun stateObserve(state: RegistrationState) {
        errorState(state)
        loadingState(state.isLoading)
    }

    private fun errorState(state: RegistrationState) = binding.apply {
        Log.e("Kart","${state.errorFieldUserName}")
        userNameLayout.error = state.errorFieldUserName
        nameLayout.error = state.errorFieldName
        errorNetwork.error.isVisible = state.isNetworkError
    }

    private fun loadingState(isLoading: Boolean) = binding.apply {
        userNameLayout.isEnabled = !isLoading
        nameLayout.isEnabled = !isLoading
        registrationButton.isEnabled = !isLoading
        progressBar.isVisible = isLoading
    }
}