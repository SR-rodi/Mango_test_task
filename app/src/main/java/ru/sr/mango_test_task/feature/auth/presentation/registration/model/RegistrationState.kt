package ru.sr.mango_test_task.feature.auth.presentation.registration.model

data class RegistrationState(
    val isLoading: Boolean = false,
    val isNetworkError: Boolean = false,
    val errorFieldName: String? = null,
    val errorFieldUserName: String? = null,
)