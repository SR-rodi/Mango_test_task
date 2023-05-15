package ru.sr.mango_test_task.presentations.auth.authorization.model

import ru.sr.mango_test_task.root.core.base.BaseState

data class AuthState(
    override val isLoading: Boolean = false,
    override val isError: Boolean = false,
    val isSuccessSendPhone:Boolean = false
) : BaseState {


}