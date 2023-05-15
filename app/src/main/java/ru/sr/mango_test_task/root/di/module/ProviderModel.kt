package ru.sr.mango_test_task.root.di.module

import android.content.Context
import dagger.Provides
import ru.sr.mango_test_task.data.provider.TokenProviderImpl
import ru.sr.mango_test_task.domain.provider.AccessTokenProvider
import ru.sr.mango_test_task.domain.provider.RefreshTokenProvider
import ru.sr.mango_test_task.domain.provider.TokenProvider

@dagger.Module
class ProviderModel {

    @Provides
    fun providerRefreshTokenProvider(context: Context): RefreshTokenProvider =
        TokenProviderImpl(context, SHARED_REFRESH_TOKEN_NAME, SHARED_REFRESH_TOKEN_KEY)

    @Provides
    fun providerAccessTokenProvider(context: Context): AccessTokenProvider =
        TokenProviderImpl(context, SHARED_ACCESS_TOKEN_NAME, SHARED_ACCESS_TOKEN_KEY)

    private companion object {
        const val SHARED_REFRESH_TOKEN_NAME = "refresh_shared"
        const val SHARED_REFRESH_TOKEN_KEY = "refresh_key"
        const val SHARED_ACCESS_TOKEN_NAME = "access_shared"
        const val SHARED_ACCESS_TOKEN_KEY = "access_key"
    }
}