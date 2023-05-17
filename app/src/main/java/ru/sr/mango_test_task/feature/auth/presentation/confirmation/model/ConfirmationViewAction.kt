package ru.sr.mango_test_task.feature.auth.presentation.confirmation.model

sealed interface ConfirmationViewAction {
    object NavigationOnRegistration : ConfirmationViewAction
    object NavigationOnProfile : ConfirmationViewAction
}