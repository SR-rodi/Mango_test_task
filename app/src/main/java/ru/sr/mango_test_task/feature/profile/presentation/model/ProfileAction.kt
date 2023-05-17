package ru.sr.mango_test_task.feature.profile.presentation.model

sealed interface ProfileAction {
    object ShowSuccessToast : ProfileAction
}