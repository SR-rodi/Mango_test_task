package ru.sr.mango_test_task.feature.auth.presentation.authorization

import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.core.base.BaseViewModel
import ru.sr.mango_test_task.core.base.LoadingState
import ru.sr.mango_test_task.feature.auth.domen.usecase.CountryUseCase
import ru.sr.mango_test_task.feature.auth.domen.usecase.SendPhoneUseCase
import ru.sr.mango_test_task.feature.auth.presentation.authorization.viewstate.AuthState

class AuthorizationViewModel(
    private val sendPhoneUseCase: SendPhoneUseCase,
    private val countryUseCase: CountryUseCase,
) : BaseViewModel<AuthState>() {

    fun getCountry() = countryUseCase.getCountry()

    fun sendPhone(phone: String) = scopeLaunch(context = Dispatchers.IO) {
        loadingState = LoadingState.Loading
        sendPhoneUseCase.send(phone)
        loadingState = LoadingState.Success
    }
}

