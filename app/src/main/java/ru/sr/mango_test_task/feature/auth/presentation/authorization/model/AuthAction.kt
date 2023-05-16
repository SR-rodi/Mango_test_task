package ru.sr.mango_test_task.feature.auth.presentation.authorization.model

sealed interface AuthAction {
    class NavigateCheckCodeFragment(val phone:String) : AuthAction
}