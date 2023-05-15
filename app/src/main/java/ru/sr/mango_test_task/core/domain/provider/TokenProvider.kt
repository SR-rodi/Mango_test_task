package ru.sr.mango_test_task.core.domain.provider

 interface TokenProvider {
    fun putToken(token: String)
    fun clearToken()
    fun getToken(): String?
    fun tokenContain(): Boolean
}

interface AccessTokenProvider: TokenProvider

interface RefreshTokenProvider: TokenProvider

