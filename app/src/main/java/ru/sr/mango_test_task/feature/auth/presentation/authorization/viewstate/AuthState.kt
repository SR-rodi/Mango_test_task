package ru.sr.mango_test_task.feature.auth.presentation.authorization.viewstate

import android.telephony.PhoneNumberFormattingTextWatcher

data class AuthState(
    val isLoading: Boolean = false,
    val isErrorNetwork: Boolean = false,
    val isErrorPhoneNumber: Boolean = false,
)

sealed interface AuthAction {
    object NavigateCheckCodeFragment : AuthAction
}