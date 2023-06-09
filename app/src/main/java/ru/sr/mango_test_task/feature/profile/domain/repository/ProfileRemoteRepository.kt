package ru.sr.mango_test_task.feature.profile.domain.repository

import android.net.Uri
import ru.sr.mango_test_task.feature.profile.data.body.Avatar
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel

interface ProfileRemoteRepository {

    suspend fun getCurrentUser(): UserProfileDomainModel

    suspend fun updateUserInfo(
        avatar: Uri?,
        name: String,
        userName: String,
        birthday: String?,
        city: String?
    ):String?
}