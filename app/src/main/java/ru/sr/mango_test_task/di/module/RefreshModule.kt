package ru.sr.mango_test_task.di.module

import dagger.Module
import dagger.Provides
import ru.sr.mango_test_task.feature.root.data.api.RefreshApi
import ru.sr.mango_test_task.feature.root.data.repository.RefreshRepositoryImpl
import ru.sr.mango_test_task.feature.root.domain.provider.AccessTokenProvider
import ru.sr.mango_test_task.feature.root.domain.provider.RefreshTokenProvider
import ru.sr.mango_test_task.feature.root.domain.repository.RefreshRepository
import javax.inject.Singleton

@Module
class RefreshModule {

    @Provides
    @Singleton
    fun providerRefreshRepository(
        api: RefreshApi,
        refreshTokenProvider: RefreshTokenProvider,
        accessTokenProvider: AccessTokenProvider,
    ): RefreshRepository = RefreshRepositoryImpl(api, refreshTokenProvider, accessTokenProvider)
}