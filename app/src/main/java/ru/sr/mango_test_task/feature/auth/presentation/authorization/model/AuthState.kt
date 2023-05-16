package ru.sr.mango_test_task.feature.auth.presentation.authorization.model

data class AuthState(
    val isLoading: Boolean = false,
    val isErrorNetwork: Boolean = false,
    val isErrorPhoneNumber: Boolean = false,
)

