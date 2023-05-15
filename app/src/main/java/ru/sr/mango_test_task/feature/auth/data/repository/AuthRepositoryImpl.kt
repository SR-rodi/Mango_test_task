package ru.sr.mango_test_task.feature.auth.data.repository

import ru.sr.mango_test_task.feature.auth.data.api.MangoApi
import ru.sr.mango_test_task.feature.auth.data.body.AuthorizationBody
import ru.sr.mango_test_task.feature.auth.data.body.CheckCodeBody
import ru.sr.mango_test_task.feature.auth.data.body.RegistrationBody
import ru.sr.mango_test_task.feature.auth.domen.model.AuthUserDomainModel
import ru.sr.mango_test_task.feature.auth.domen.repository.AuthRepository
import ru.sr.mango_test_task.core.domain.provider.AccessTokenProvider
import ru.sr.mango_test_task.core.domain.provider.RefreshTokenProvider

class AuthRepositoryImpl(
    private val api: MangoApi,
    private val refreshTokenProvider: RefreshTokenProvider,
    private val accessTokenProvider: AccessTokenProvider,
) :
    AuthRepository {
    override suspend fun sendPhone(phone: String): Boolean {
        return api.userAuthorization(AuthorizationBody(phone)).isSuccess
    }

    override suspend fun checkCode(phone: String, code: String): AuthUserDomainModel {
        val user = api.userCheckAuthorizationCode(CheckCodeBody(phone, code)).toAuthUserDomain()
        saveTokens(user.refreshToken, user.accessToken)
        return user
    }

    override suspend fun userRegistration(
        phone: String,
        name: String,
        username: String,
    ): AuthUserDomainModel {
        val user = api.userRegistration(RegistrationBody(phone, name, username)).toAuthUserDomain()
        saveTokens(user.refreshToken, user.accessToken)
        return user
    }

    private fun saveTokens(refreshToken: String, accessToken: String) {
        refreshTokenProvider.putToken(refreshToken)
        accessTokenProvider.putToken(accessToken)
    }


}