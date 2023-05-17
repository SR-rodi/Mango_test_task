package ru.sr.mango_test_task.feature.profile.domain.repository

import android.net.Uri
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel

interface ProfileLocationRepository {

    suspend fun getCurrentUser(): UserProfileDomainModel?

    suspend fun insertUser(user: UserProfileDomainModel)

    suspend fun updateUser(
        userAvatar: String?,
        name: String,
        userName: String,
        birthday: String?,
        city: String?,
        phone:String
    )

    suspend fun deleteUser(user: UserProfileDomainModel)
}