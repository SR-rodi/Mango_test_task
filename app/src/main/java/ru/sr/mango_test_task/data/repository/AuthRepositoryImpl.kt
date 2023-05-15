package ru.sr.mango_test_task.data.repository

import ru.sr.mango_test_task.data.api.MangoApi
import ru.sr.mango_test_task.data.body.AuthorizationBody
import ru.sr.mango_test_task.data.body.CheckCodeBody
import ru.sr.mango_test_task.domain.auth.model.AuthUserDomainModel
import ru.sr.mango_test_task.domain.auth.repository.AuthRepository
import ru.sr.mango_test_task.domain.provider.AccessTokenProvider
import ru.sr.mango_test_task.domain.provider.RefreshTokenProvider

class AuthRepositoryImpl(
    private val api: MangoApi,
    private val refreshTokenProvider: RefreshTokenProvider,
    private val accessTokenProvider: AccessTokenProvider
) :
    AuthRepository {
    override suspend fun sendPhone(phone: String):Boolean {
       return api.userAuthorization(AuthorizationBody(phone)).isSuccess
    }

    override suspend fun checkCode(phone: String, code: String): AuthUserDomainModel {
        val user = api.userCheckAuthorizationCode(CheckCodeBody(phone, code)).toAuthUserDomain()
        refreshTokenProvider.putToken(user.refreshToken)
        accessTokenProvider.putToken(user.accessToken)
        return user
    }
}