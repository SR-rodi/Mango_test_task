package ru.sr.mango_test_task.feature.profile.domain.usecase.impl

import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileLocationRepository
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileRemoteRepository
import ru.sr.mango_test_task.feature.profile.domain.usecase.GetUserUseCase

class GetUserUseCaseImpl(
    private val locationRepository: ProfileLocationRepository,
    private val remoteRepository: ProfileRemoteRepository,
) : GetUserUseCase {
    override suspend fun get(): UserProfileDomainModel {
        val locationUser = locationRepository.getCurrentUser()
        if (locationUser != null) return locationUser
        val currentUser = remoteRepository.getCurrentUser()
        locationRepository.insertUser(currentUser)
        return currentUser
    }
}