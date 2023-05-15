package ru.sr.mango_test_task.feature.auth.presentation.authorization

import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.feature.auth.domen.usecase.SendPhoneUseCase
import ru.sr.mango_test_task.core.base.BaseViewModel
import ru.sr.mango_test_task.core.base.LoadingState

class AuthorizationViewModel(
    private val sendPhoneUseCase: SendPhoneUseCase,
) : BaseViewModel<AuthState>() {

    fun sendPhone(phone: String) = scopeLaunch(context = Dispatchers.IO) {
        loadingState = LoadingState.Loading
        sendPhoneUseCase.send(phone)
        loadingState = LoadingState.Success
    }
}

enum class AuthState{

}