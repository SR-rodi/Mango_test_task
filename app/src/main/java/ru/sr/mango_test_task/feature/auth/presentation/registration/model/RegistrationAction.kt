package ru.sr.mango_test_task.feature.auth.presentation.registration.model

sealed interface RegistrationAction {
    object NavigateProfile : RegistrationAction
}