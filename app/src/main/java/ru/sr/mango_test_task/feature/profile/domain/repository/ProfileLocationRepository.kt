package ru.sr.mango_test_task.feature.profile.domain.repository

import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel

interface ProfileLocationRepository {

    suspend fun getCurrentUser(): UserProfileDomainModel?

    suspend fun insertUser(user: UserProfileDomainModel)

    suspend fun deleteUser(user: UserProfileDomainModel)
}