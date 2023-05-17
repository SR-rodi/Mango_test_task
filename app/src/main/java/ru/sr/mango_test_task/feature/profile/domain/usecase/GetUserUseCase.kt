package ru.sr.mango_test_task.feature.profile.domain.usecase

import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel

interface GetUserUseCase {
    suspend fun get(): UserProfileDomainModel
}