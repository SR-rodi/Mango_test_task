package ru.sr.mango_test_task.feature.auth.presentation.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.core.base.BaseFragment
import ru.sr.mango_test_task.core.extension.setOnSelectedItem
import ru.sr.mango_test_task.databinding.FragmentAuthorizationBinding
import ru.sr.mango_test_task.feature.auth.presentation.authorization.adapter.PhoneCodeAdapter
import ru.sr.mango_test_task.feature.auth.presentation.authorization.adapter.CountryAdapter
import ru.sr.mango_test_task.feature.auth.presentation.authorization.model.AuthAction
import ru.sr.mango_test_task.feature.auth.presentation.authorization.model.AuthState
import ru.sr.mango_test_task.core.extension.setFormatMask
import ru.sr.mango_test_task.core.extension.setMask
import ru.sr.mango_test_task.core.extension.toStringWithoutMask

class AuthorizationFragment : BaseFragment<FragmentAuthorizationBinding>() {

    private val viewModel by lazy { initViewModel<AuthorizationViewModel>() }

    private val phoneCodeAdapter by lazy {
        PhoneCodeAdapter(viewModel.getCountry().values.toList())
    }
    private val adapterCountry by lazy {
        CountryAdapter(viewModel.getCountry().keys.toList())
    }

    override fun initBinding(inflater: LayoutInflater) =
        FragmentAuthorizationBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.phoneNumber.setMask()
        settingSpinners()
        onAuthClickButton()
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }
        flowObserver(viewModel.viewAction()) { action -> actionObserver(action) }
    }

    private fun actionObserver(action: AuthAction?) {
        when (action) {
            is AuthAction.NavigateCheckCodeFragment -> {
                navigationToConfirmationCodeFragment(action.phone)
                viewModel.onResetAction()
            }

            null -> {}
        }
    }

    private fun settingSpinners() {
        binding.countryCode.adapter = phoneCodeAdapter
        binding.countryCode.setOnSelectedItem { position ->
            binding.countryFlag.setSelection(position)
            viewModel.setCurrentPhoneCode(binding.countryCode.adapter.getItem(position))
        }

        binding.countryFlag.adapter = adapterCountry
        binding.countryFlag.setOnSelectedItem { position ->
            binding.countryCode.setSelection(position)
            binding.phoneNumber.setFormatMask(phoneCodeAdapter.getItem(position).format)
            binding.phoneLayout.hint = phoneCodeAdapter.getItem(position).format
            binding.phoneNumber.setText(binding.phoneNumber.text.toString())
        }
    }

    private fun onAuthClickButton() = binding.authButton.setOnClickListener {
        viewModel.sendPhone(binding.phoneNumber.toStringWithoutMask())
    }

    private fun stateObserver(state: AuthState) {
        loadState(state.isLoading)
        errorPhoneState(state.isErrorPhoneNumber)
        binding.errorNetwork.error.isVisible = state.isErrorNetwork
    }

    private fun errorPhoneState(errorPhoneNumber: Boolean) {
        binding.phoneLayout.error =
            if (errorPhoneNumber) getString(R.string.no_verification_phone_number)
            else null
    }

    private fun navigationToConfirmationCodeFragment(phone: String) = navigation(
        AuthorizationFragmentDirections.actionAuthorizationFragmentToConfirmationCodeFragment(phone)
    )


    private fun loadState(isLoading: Boolean) = binding.apply {
        phoneLayout.isEnabled = !isLoading
        countryCode.isEnabled = !isLoading
        countryFlag.isEnabled = !isLoading
        authButton.isEnabled = !isLoading
        progressBar.isVisible = isLoading
    }

}