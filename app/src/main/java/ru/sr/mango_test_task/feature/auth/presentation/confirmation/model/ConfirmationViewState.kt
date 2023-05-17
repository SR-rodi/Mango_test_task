package ru.sr.mango_test_task.feature.auth.presentation.confirmation.model

data class ConfirmationViewState(
    val isLoading: Boolean = false,
    val isNetworkError: Boolean = false,
    val ErrorMessageField: String? = null,
)