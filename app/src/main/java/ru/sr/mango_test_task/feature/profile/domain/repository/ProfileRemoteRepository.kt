package ru.sr.mango_test_task.feature.profile.domain.repository

import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel

interface ProfileRemoteRepository {

    suspend fun getCurrentUser(): UserProfileDomainModel

    suspend fun updateUserInfo()
}