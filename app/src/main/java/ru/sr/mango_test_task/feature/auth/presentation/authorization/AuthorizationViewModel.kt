package ru.sr.mango_test_task.feature.auth.presentation.authorization

import android.util.Log
import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.core.base.BaseViewModel
import ru.sr.mango_test_task.feature.auth.data.repository.PhoneFormat
import ru.sr.mango_test_task.feature.auth.domen.usecase.CountryUseCase
import ru.sr.mango_test_task.feature.auth.domen.usecase.SendPhoneUseCase
import ru.sr.mango_test_task.feature.auth.presentation.authorization.model.AuthAction
import ru.sr.mango_test_task.feature.auth.presentation.authorization.model.AuthState

class AuthorizationViewModel(
    private val sendPhoneUseCase: SendPhoneUseCase,
    private val countryUseCase: CountryUseCase,
) : BaseViewModel<AuthState, AuthAction>(AuthState()) {

    private var phoneCode = ""

    fun getCountry() =
        countryUseCase.getCountry()

    fun sendPhone(phone: String) = scopeLaunch(context = Dispatchers.IO, onError = ::onError) {
        val newPhone = phoneCode + phone
        if (newPhone.length == 12) {
            viewState =
                viewState.copy(isLoading = true, isErrorNetwork = false, isErrorPhoneNumber = false)
            sendPhoneUseCase.send("$phoneCode$phone")
            viewState = viewState.copy(isLoading = false)
            viewAction = AuthAction.NavigateCheckCodeFragment(newPhone)
        } else viewState = viewState.copy(isErrorPhoneNumber = true)
    }

    private fun onError(error: Exception) {
        Log.e("Kart","$error")
        viewState =
            viewState.copy(isLoading = false, isErrorNetwork = true, isErrorPhoneNumber = false)
    }

    fun setCurrentPhoneCode(code: Any?) {
        if (code is PhoneFormat)
            phoneCode = code.code
    }
}

