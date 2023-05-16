package ru.sr.mango_test_task.feature.auth.data.repository

import ru.sr.mango_test_task.feature.root.domain.provider.AccessTokenProvider
import ru.sr.mango_test_task.feature.root.domain.provider.RefreshTokenProvider
import ru.sr.mango_test_task.feature.auth.data.api.MangoApi
import ru.sr.mango_test_task.feature.auth.data.body.AuthorizationBody
import ru.sr.mango_test_task.feature.auth.data.body.CheckCodeBody
import ru.sr.mango_test_task.feature.auth.data.body.RegistrationBody
import ru.sr.mango_test_task.feature.auth.domen.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: MangoApi,
    private val refreshTokenProvider: RefreshTokenProvider,
    private val accessTokenProvider: AccessTokenProvider,
) :
    AuthRepository {
    override suspend fun sendPhone(phone: String): Boolean {
        return api.userAuthorization(AuthorizationBody(phone)).isSuccess
    }

    override suspend fun checkCode(phone: String, code: String): Boolean {
        val user = api.userCheckAuthorizationCode(CheckCodeBody(phone, code))
        saveTokens(user.refreshToken, user.accessToken)
        return user.isUserExists
    }

    override suspend fun userRegistration(
        phone: String,
        name: String,
        username: String,
    ) {
        val user = api.userRegistration(RegistrationBody(phone, name, username))
        saveTokens(user.refreshToken, user.accessToken)

    }

    private fun saveTokens(refreshToken: String?, accessToken: String?) {
        refreshTokenProvider.putToken(refreshToken)
        accessTokenProvider.putToken(accessToken)
    }


}