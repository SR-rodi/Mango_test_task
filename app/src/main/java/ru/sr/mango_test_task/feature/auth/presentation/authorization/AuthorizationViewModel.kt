package ru.sr.mango_test_task.feature.auth.presentation.authorization

import android.util.Log
import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.core.base.BaseViewModel
import ru.sr.mango_test_task.feature.auth.data.PhoneFormat
import ru.sr.mango_test_task.feature.auth.domen.usecase.CountryUseCase
import ru.sr.mango_test_task.feature.auth.domen.usecase.SendPhoneUseCase
import ru.sr.mango_test_task.feature.auth.presentation.authorization.model.AuthAction
import ru.sr.mango_test_task.feature.auth.presentation.authorization.model.AuthState
import ru.sr.mango_test_task.feature.root.domain.provider.ResourceProvider

class AuthorizationViewModel(
    private val sendPhoneUseCase: SendPhoneUseCase,
    private val countryUseCase: CountryUseCase,
    private val resource: ResourceProvider,
) : BaseViewModel<AuthState, AuthAction>(AuthState()) {

    private var phoneCode = ""

    fun getCountry() =
        countryUseCase.getCountry()

    fun sendPhone(phone: String) = scopeLaunch(context = Dispatchers.IO, onError = ::onError) {
        val newPhone = phoneCode + phone
        if (newPhone.length == 12) {
            onStartLoading()
            sendPhoneUseCase.send(newPhone)
            onSuccessLoading(newPhone)
        } else onErrorValidation(resource.getString(R.string.no_verification_phone_number))
    }

    private fun onStartLoading() {
        viewState =
            viewState.copy(isLoading = true, isErrorNetwork = false, errorPhoneNumber = null)
    }

    private fun onSuccessLoading(newPhone: String) {
        viewState = viewState.copy(isLoading = false)
        viewAction = AuthAction.NavigateCheckCodeFragment(newPhone)
    }

    private fun onErrorValidation(message: String) {
        viewState = viewState.copy(errorPhoneNumber = message)
    }

    private fun onError(error: Exception) {
        Log.e("Kart", "$error")
        viewState =
            viewState.copy(isLoading = false, isErrorNetwork = true, errorPhoneNumber = null)
    }

    fun setCurrentPhoneCode(code: Any?) {
        if (code is PhoneFormat)
            phoneCode = code.code
    }
}

