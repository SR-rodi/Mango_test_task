package ru.sr.mango_test_task.feature.profile.di

import dagger.Module
import dagger.Provides
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileLocationRepository
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileRemoteRepository
import ru.sr.mango_test_task.feature.profile.domain.usecase.GetUserUseCase
import ru.sr.mango_test_task.feature.profile.domain.usecase.impl.GetUserUseCaseImpl
import javax.inject.Singleton

@Module
class ProfileUseCaseModule() {

    @Provides
    @Singleton
    fun providerGetUserUseCase(
        remoteRepository: ProfileRemoteRepository,
        locationRepository: ProfileLocationRepository,
    ): GetUserUseCase =
        GetUserUseCaseImpl(locationRepository, remoteRepository)
}