package ru.sr.mango_test_task.feature.auth.presentation.registration

import android.util.Log
import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.core.base.BaseViewModel
import ru.sr.mango_test_task.feature.auth.domen.usecase.RegistrationUseCase
import ru.sr.mango_test_task.feature.auth.presentation.registration.model.RegistrationAction
import ru.sr.mango_test_task.feature.auth.presentation.registration.model.RegistrationState
import ru.sr.mango_test_task.feature.root.domain.provider.ResourceProvider
import ru.sr.mango_test_task.feature.root.domain.validation.UserNameValidation

class RegistrationViewModel(
    private val registrationUseCase: RegistrationUseCase,
    private val nameValidator: UserNameValidation,
    private val resource: ResourceProvider,
) : BaseViewModel<RegistrationState, RegistrationAction>(RegistrationState()) {

    fun userRegistration(phone: String, name: String, username: String) =
        scopeLaunch(context = Dispatchers.IO, onError = ::onError) {
            val isValidationUserName = nameValidator.checkUserName(username)
            val isValidationName = nameValidator.checkName(name)

            if (isValidationUserName && isValidationName) {
                startLoading()
                registrationUseCase.registration(phone, name, username)
                finishLoading()
            } else notValidationError(isValidationUserName, isValidationName)
        }


    private fun notValidationError(isValidationUserName: Boolean, isValidationName: Boolean) {
        viewState = viewState.copy(
            errorFieldUserName = setErrorMessage(isValidationUserName),
            errorFieldName = setErrorMessage(isValidationName)
        )
    }

    private fun setErrorMessage(isValidation: Boolean) =
        if (!isValidation) resource.getString(R.string.registration_error_message) else null


    private fun startLoading() {
        viewState = viewState.copy(
            isLoading = true,
            isNetworkError = false,
            errorFieldName = null,
            errorFieldUserName = null
        )
    }

    private fun finishLoading() {
        viewState = RegistrationState()
        viewAction = RegistrationAction.NavigateProfile
    }



    private fun onError(exception: Exception) {
        Log.e("Kart", exception.toString())
        viewState = viewState.copy(
            isNetworkError = false,
            isLoading = false,
        )
    }
}

