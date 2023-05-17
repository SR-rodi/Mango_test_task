package ru.sr.mango_test_task.feature.root.data.repository

import ru.sr.mango_test_task.feature.root.data.RefreshApi
import ru.sr.mango_test_task.feature.root.data.RefreshBody
import ru.sr.mango_test_task.feature.root.domain.provider.AccessTokenProvider
import ru.sr.mango_test_task.feature.root.domain.provider.RefreshTokenProvider
import ru.sr.mango_test_task.feature.root.domain.repository.RefreshRepository

class RefreshRepositoryImpl(
    private val api: RefreshApi,
    private val refreshTokenProvider: RefreshTokenProvider,
    private val accessTokenProvider: AccessTokenProvider,
) : RefreshRepository {

    override suspend fun refresh() {
        val currentRefreshToken = refreshTokenProvider.getToken()
        if (currentRefreshToken != null) {
            val newTokens = api.refreshToken(RefreshBody(currentRefreshToken))
            refreshTokenProvider.putToken(newTokens.refresh_token)
            accessTokenProvider.putToken(newTokens.access_token)
        }

    }
}