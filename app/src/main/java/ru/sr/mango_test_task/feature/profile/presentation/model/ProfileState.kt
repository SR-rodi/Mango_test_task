package ru.sr.mango_test_task.feature.profile.presentation.model

import android.net.Uri

data class ProfileState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val user: UserProfileUIModel? = null,
    val avatarUriUpdate: Uri? = null,
)