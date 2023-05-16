package ru.sr.mango_test_task.feature.auth.presentation.confirmation

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.sr.mango_test_task.feature.auth.domen.usecase.CheckCodeUseCase
import ru.sr.mango_test_task.core.base.BaseViewModel

class ConfirmationCodeViewModel(
    private val checkCodeUseCase: CheckCodeUseCase,
) : BaseViewModel<String,ConfirmationViewState>("") {

    private val _isRegistrationUser = MutableStateFlow(false)
    val isRegistrationUser = _isRegistrationUser.asStateFlow()

    fun checkCode(phone: String, code: String) =
        scopeLaunch(context = Dispatchers.IO, onError = { Log.e("Kart", it.toString()) }) {
            Log.e("Kart", "Test =  ${checkCodeUseCase.check(phone, code).accessToken}")
        }
}

enum class ConfirmationViewState{
    NavigationOnRegistration,Start,NavigationOnProfile
}
