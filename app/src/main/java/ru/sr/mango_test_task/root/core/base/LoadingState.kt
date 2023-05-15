package ru.sr.mango_test_task.root.core.base

sealed interface LoadingState {
    object Loading : LoadingState
    object Success : LoadingState
    object Error : LoadingState
    object Start : LoadingState
}
