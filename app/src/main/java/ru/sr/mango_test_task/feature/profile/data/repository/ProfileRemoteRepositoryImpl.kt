package ru.sr.mango_test_task.feature.profile.data.repository

import ru.sr.mango_test_task.feature.profile.data.api.ProfileApi
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileRemoteRepository

class ProfileRemoteRepositoryImpl(
    private val api:ProfileApi
) :ProfileRemoteRepository{
    override suspend fun getCurrentUser(): UserProfileDomainModel {
       return api.getCurrentUser().profile.toDomain()
    }

    override suspend fun updateUserInfo() {
        api.updateUser()
    }
}