package ru.sr.mango_test_task.feature.auth.presentation.confirmation

import android.util.Log
import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.core.base.BaseViewModel
import ru.sr.mango_test_task.feature.auth.domen.usecase.CheckCodeUseCase
import ru.sr.mango_test_task.feature.auth.presentation.confirmation.model.ConfirmationViewAction
import ru.sr.mango_test_task.feature.auth.presentation.confirmation.model.ConfirmationViewState
import ru.sr.mango_test_task.feature.root.domain.provider.ResourceProvider

class ConfirmationCodeViewModel(
    private val checkCodeUseCase: CheckCodeUseCase,
    private val resource: ResourceProvider,
) : BaseViewModel<ConfirmationViewState, ConfirmationViewAction>(ConfirmationViewState()) {

    fun checkCode(phone: String, code: String) =
        scopeLaunch(context = Dispatchers.IO, onError = ::onError) {
            if (code.length == 6) {
                startLoading()
                val isVerifierUser = checkCodeUseCase.check(phone, code)
                onSuccessLoading(isVerifierUser)
            } else
                notValidationError(resource.getString(R.string.auth_confirmation_no_verification_local_code))
        }

    private fun startLoading() {
        viewState = viewState.copy(
            ErrorMessageField = null,
            isLoading = true,
            isNetworkError = false
        )
    }

    private fun onSuccessLoading(isVerifierUser: Boolean) {
        viewAction = if (isVerifierUser)
            ConfirmationViewAction.NavigationOnProfile
        else ConfirmationViewAction.NavigationOnRegistration
        viewState = ConfirmationViewState()
    }

    private fun notValidationError(message: String) {
        viewState = viewState.copy(ErrorMessageField = message)
    }

    private fun onError(exception: Exception) {
        Log.e("Kart", "Error = $exception}")
        viewState = if (exception.message == "HTTP 404 Not Found") {
            viewState.copy(
                isLoading = false,
                ErrorMessageField = resource.getString(R.string.auth_confirmation_no_verification_remote_code),
                isNetworkError = false
            )
        } else viewState.copy(
            ErrorMessageField = null, isNetworkError = true, isLoading = false,
        )
    }
}

