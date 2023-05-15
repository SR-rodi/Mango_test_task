package ru.sr.mango_test_task.feature.auth.presentation.authorization.viewstate

sealed interface AuthState{
    object ErrorPhoneNumber:AuthState
    object NavigateCheckCodeFragment:AuthState
}