package ru.sr.mango_test_task.feature.auth.presentation.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
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

    private val phoneCodeAdapter by lazy { PhoneCodeAdapter() }
    private val adapterCountry by lazy { CountryAdapter() }

    override fun initBinding(inflater: LayoutInflater) =
        FragmentAuthorizationBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.phoneNumber.setMask()
        settingSpinners()
        binding.authButton.setOnClickListener { onAuthClickButton() }
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }
        flowObserver(viewModel.viewAction()) { action -> actionObserver(action) }
    }

    private fun actionObserver(action: AuthAction?) {
        when (action) {
            is AuthAction.NavigateCheckCodeFragment ->
                navigationToConfirmationCodeFragment(action.phone)

            null -> {}
        }
    }

    private fun settingSpinners() = binding.apply {
        phoneCodeAdapter.setItems(viewModel.getCountry().values.toList())
        countryCode.adapter = phoneCodeAdapter
        countryCode.setOnSelectedItem { position ->
            countryFlag.setSelection(position)
            viewModel.setCurrentPhoneCode(binding.countryCode.adapter.getItem(position))
        }

        adapterCountry.setItems(viewModel.getCountry().keys.toList())
        countryFlag.adapter = adapterCountry
        countryFlag.setOnSelectedItem { position ->
            countryCode.setSelection(position)
            phoneNumber.setFormatMask(phoneCodeAdapter.getItem(position).format)
            phoneLayout.hint = phoneCodeAdapter.getItem(position).format
            phoneNumber.setText(binding.phoneNumber.text.toString())
        }
    }

    private fun onAuthClickButton() = viewModel.sendPhone(binding.phoneNumber.toStringWithoutMask())

    private fun stateObserver(state: AuthState) = binding.apply {
        loadState(state.isLoading)
        binding.phoneLayout.error = state.errorPhoneNumber
        binding.errorNetwork.error.isVisible = state.isErrorNetwork
    }

    private fun navigationToConfirmationCodeFragment(phone: String) {
        navigation(
            AuthorizationFragmentDirections
                .actionAuthorizationFragmentToConfirmationCodeFragment(phone)
        )
        viewModel.onResetAction()
    }

    private fun loadState(isLoading: Boolean) = binding.apply {
        phoneLayout.isEnabled = !isLoading
        countryCode.isEnabled = !isLoading
        countryFlag.isEnabled = !isLoading
        authButton.isEnabled = !isLoading
        progressBar.isVisible = isLoading
    }
}