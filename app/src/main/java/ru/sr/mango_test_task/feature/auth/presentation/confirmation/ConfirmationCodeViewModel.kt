package ru.sr.mango_test_task.feature.auth.presentation.confirmation

import android.util.Log
import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.core.base.BaseViewModel
import ru.sr.mango_test_task.feature.auth.domen.usecase.CheckCodeUseCase
import ru.sr.mango_test_task.feature.auth.presentation.confirmation.model.ConfirmationViewAction
import ru.sr.mango_test_task.feature.auth.presentation.confirmation.model.ConfirmationViewState

class ConfirmationCodeViewModel(
    private val checkCodeUseCase: CheckCodeUseCase,
) : BaseViewModel<ConfirmationViewState, ConfirmationViewAction>(ConfirmationViewState()) {

    fun checkCode(phone: String, code: String) =
        scopeLaunch(context = Dispatchers.IO, onError = ::onError) {
            Log.e("Kart","Trst = ${code.length}")
            if (code.length == 6) {
                viewState = viewState.copy(
                    isCodeFieldError = false,
                    isLoading = true,
                    isNetworkError = false
                )
                viewAction = if (checkCodeUseCase.check(phone, code).isUserExists == true)
                    ConfirmationViewAction.NavigationOnProfile
                else ConfirmationViewAction.NavigationOnRegistration
                viewState = viewState.copy(
                    isCodeFieldError = false,
                    isLoading = false,
                    isNetworkError = false
                )
            } else viewState = viewState.copy(isCodeFieldError = true)


        }

    private fun onError(exception: Exception) {
        if (exception.message == "HTTP 404 Not Found") {
            viewAction = ConfirmationViewAction.NavigationOnRegistration
        } else viewState = viewState.copy(
            isCodeFieldError = false, isNetworkError = true
        )
    }
}

