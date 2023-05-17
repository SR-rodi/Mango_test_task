package ru.sr.mango_test_task.feature.auth.di

import dagger.Module
import dagger.Provides
import ru.sr.mango_test_task.feature.auth.data.api.MangoApi
import ru.sr.mango_test_task.feature.auth.data.repository.AuthRepositoryImpl
import ru.sr.mango_test_task.feature.auth.domen.repository.AuthRepository
import ru.sr.mango_test_task.feature.root.domain.provider.AccessTokenProvider
import ru.sr.mango_test_task.feature.root.domain.provider.RefreshTokenProvider
import ru.sr.mango_test_task.feature.auth.data.repository.CountryRepositoryImpl
import ru.sr.mango_test_task.feature.auth.domen.repository.CountryRepository
import ru.sr.mango_test_task.feature.root.domain.provider.UserIdProvider
import javax.inject.Singleton

@Module
class AuthRepositoryModule {

    @Provides
    @Singleton
    fun providerAuthRepository(
        api: MangoApi,
        refreshTokenProvider: RefreshTokenProvider,
        accessTokenProvider: AccessTokenProvider,
        userIdProvider: UserIdProvider
    ): AuthRepository = AuthRepositoryImpl(api, refreshTokenProvider, accessTokenProvider,userIdProvider)

    @Provides
    fun providerCountryRepository():CountryRepository = CountryRepositoryImpl()
}