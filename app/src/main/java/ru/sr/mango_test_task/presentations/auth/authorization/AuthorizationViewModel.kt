package ru.sr.mango_test_task.presentations.auth.authorization

import android.util.Log
import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.domain.auth.usecase.CheckCodeUseCase
import ru.sr.mango_test_task.domain.auth.usecase.SendPhoneUseCase
import ru.sr.mango_test_task.presentations.auth.authorization.model.AuthState
import ru.sr.mango_test_task.root.core.base.BaseViewModel
import java.lang.Exception

class AuthorizationViewModel(
    private val sendPhoneUseCase: SendPhoneUseCase,
    private val checkCodeUseCase: CheckCodeUseCase,
) : BaseViewModel<AuthState>(AuthState()) {

    fun sendPhone(phone: String) = scopeLaunch(context = Dispatchers.IO, onError = ::onError) {
        viewState = viewState.copy(isLoading = true)
        viewState = viewState.copy(isSuccessSendPhone = sendPhoneUseCase.send(phone))
        viewState = viewState.copy(isLoading = false)
    }

    fun checkCode(phone: String, code: String) =
        scopeLaunch(context = Dispatchers.IO, onError = ::onError) {
            viewState = viewState.copy(isLoading = true)
            checkCodeUseCase.check(phone, code)
            viewState = viewState.copy(isLoading = false)
        }

    private fun onError(exception: Exception) {
        Log.e("Kart", exception.toString())
        viewState = viewState.copy(isError = true)
    }
}