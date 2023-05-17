package ru.sr.mango_test_task.feature.profile.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.sr.mango_test_task.feature.profile.data.api.ProfileApi
import ru.sr.mango_test_task.feature.profile.data.database.UserDao
import ru.sr.mango_test_task.feature.profile.data.repository.ProfileLocationRepositoryImpl
import ru.sr.mango_test_task.feature.profile.data.repository.ProfileRemoteRepositoryImpl
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileLocationRepository
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileRemoteRepository
import ru.sr.mango_test_task.feature.root.domain.encoder.Base64Encoder
import javax.inject.Singleton

@Module
class ProfileRepositoryModule {

    @Provides
    @Singleton
    fun providerProfileRemoteRepository(api: ProfileApi,encoder: Base64Encoder): ProfileRemoteRepository =
        ProfileRemoteRepositoryImpl(api,encoder)

    @Provides
    @Singleton
    fun providerProfileLocationRepository(dao: UserDao): ProfileLocationRepository =
        ProfileLocationRepositoryImpl(dao)
}