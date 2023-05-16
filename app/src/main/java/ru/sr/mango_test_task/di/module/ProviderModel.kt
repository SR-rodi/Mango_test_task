package ru.sr.mango_test_task.di.module

import android.content.Context
import dagger.Provides
import ru.sr.mango_test_task.feature.root.data.provider.ResourceProviderImpl
import ru.sr.mango_test_task.feature.root.data.provider.TokenProviderImpl
import ru.sr.mango_test_task.feature.root.domain.provider.AccessTokenProvider
import ru.sr.mango_test_task.feature.root.domain.provider.RefreshTokenProvider
import ru.sr.mango_test_task.feature.root.domain.provider.ResourceProvider

@dagger.Module
class ProviderModel {

    @Provides
    fun providerRefreshTokenProvider(context: Context): RefreshTokenProvider =
        TokenProviderImpl(context, SHARED_REFRESH_TOKEN_NAME, SHARED_REFRESH_TOKEN_KEY)

    @Provides
    fun providerAccessTokenProvider(context: Context): AccessTokenProvider =
        TokenProviderImpl(context, SHARED_ACCESS_TOKEN_NAME, SHARED_ACCESS_TOKEN_KEY)

    @Provides
    fun providerResourceProvider(context: Context): ResourceProvider =
        ResourceProviderImpl(context.resources)

    private companion object {
        const val SHARED_REFRESH_TOKEN_NAME = "refresh_shared"
        const val SHARED_REFRESH_TOKEN_KEY = "refresh_key"
        const val SHARED_ACCESS_TOKEN_NAME = "access_shared"
        const val SHARED_ACCESS_TOKEN_KEY = "access_key"
    }
}