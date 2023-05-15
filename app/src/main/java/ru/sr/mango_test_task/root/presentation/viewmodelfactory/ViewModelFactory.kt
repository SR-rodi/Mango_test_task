package ru.sr.mango_test_task.root.presentation.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.sr.mango_test_task.domain.auth.usecase.CheckCodeUseCase
import ru.sr.mango_test_task.domain.auth.usecase.SendPhoneUseCase
import ru.sr.mango_test_task.presentations.auth.authorization.AuthorizationViewModel
import ru.sr.mango_test_task.presentations.auth.confirmation.ConfirmationCodeViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val sendPhoneUseCase: SendPhoneUseCase,
    private val checkCodeUseCase: CheckCodeUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when (modelClass) {
        AuthorizationViewModel::class.java->
            AuthorizationViewModel(sendPhoneUseCase) as T
        ConfirmationCodeViewModel::class.java->
            ConfirmationCodeViewModel(checkCodeUseCase) as T
        else -> throw IllegalAccessError("error create viewModel")
    }
}