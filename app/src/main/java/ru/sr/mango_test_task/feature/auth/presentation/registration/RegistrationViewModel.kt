package ru.sr.mango_test_task.feature.auth.presentation.registration

import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.feature.auth.domen.usecase.RegistrationUseCase
import ru.sr.mango_test_task.core.base.BaseViewModel

class RegistrationViewModel(
    private val registrationUseCase: RegistrationUseCase,
) : BaseViewModel<String,String>("") {

    fun userRegistration(phone: String, name: String, username: String) =
        scopeLaunch(context = Dispatchers.IO) {
            registrationUseCase.registration(phone, name, username)
        }
}

enum class RegistrationState {

}