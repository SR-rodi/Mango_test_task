package ru.sr.mango_test_task.feature.root.presentations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.sr.mango_test_task.feature.auth.domen.usecase.CheckCodeUseCase
import ru.sr.mango_test_task.feature.auth.domen.usecase.CountryUseCase
import ru.sr.mango_test_task.feature.auth.domen.usecase.RegistrationUseCase
import ru.sr.mango_test_task.feature.auth.domen.usecase.SendPhoneUseCase
import ru.sr.mango_test_task.feature.auth.presentation.authorization.AuthorizationViewModel
import ru.sr.mango_test_task.feature.auth.presentation.confirmation.ConfirmationCodeViewModel
import ru.sr.mango_test_task.feature.auth.presentation.registration.RegistrationViewModel
import ru.sr.mango_test_task.feature.root.domain.provider.ResourceProvider
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val sendPhoneUseCase: SendPhoneUseCase,
    private val checkCodeUseCase: CheckCodeUseCase,
    private val registrationUseCase: RegistrationUseCase,
    private val countryUseCase: CountryUseCase,
    private val resourceProvider: ResourceProvider
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when (modelClass) {
        AuthorizationViewModel::class.java->
            AuthorizationViewModel(sendPhoneUseCase,countryUseCase) as T
        ConfirmationCodeViewModel::class.java->
            ConfirmationCodeViewModel(checkCodeUseCase,resourceProvider) as T
        RegistrationViewModel::class.java->
            RegistrationViewModel(registrationUseCase) as T
        else -> throw IllegalAccessError("error create viewModel")
    }
}