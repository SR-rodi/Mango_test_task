package ru.sr.mango_test_task.feature.profile.domain.usecase

import android.net.Uri

interface UpdateUserUseCase {

    suspend fun update(
        userAvatar: Uri?,
        name: String,
        userName: String,
        birthday: String?,
        city: String?,
        phone:String,
        currentAvatar:String?,
    ):String?
}