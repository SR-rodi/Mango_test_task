package ru.sr.mango_test_task.presentations.auth.authorization

import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.domain.auth.usecase.SendPhoneUseCase
import ru.sr.mango_test_task.root.core.base.BaseViewModel
import ru.sr.mango_test_task.root.core.base.LoadingState

class AuthorizationViewModel(
    private val sendPhoneUseCase: SendPhoneUseCase,
) : BaseViewModel() {

    fun sendPhone(phone: String) = scopeLaunch(context = Dispatchers.IO) {
        loadingState = LoadingState.Loading
        sendPhoneUseCase.send(phone)
        loadingState = LoadingState.Success
    }
}