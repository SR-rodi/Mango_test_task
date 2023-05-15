package ru.sr.mango_test_task.root.di.module

import dagger.Module
import dagger.Provides
import ru.sr.mango_test_task.data.api.MangoApi
import ru.sr.mango_test_task.data.repository.AuthRepositoryImpl
import ru.sr.mango_test_task.domain.auth.repository.AuthRepository
import ru.sr.mango_test_task.domain.provider.AccessTokenProvider
import ru.sr.mango_test_task.domain.provider.RefreshTokenProvider
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providerAuthRepository(
        api: MangoApi,
        refreshTokenProvider: RefreshTokenProvider,
        accessTokenProvider: AccessTokenProvider,
    ): AuthRepository = AuthRepositoryImpl(api, refreshTokenProvider, accessTokenProvider)
}