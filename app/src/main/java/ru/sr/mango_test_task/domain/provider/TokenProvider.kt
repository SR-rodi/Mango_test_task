package ru.sr.mango_test_task.domain.provider

interface TokenProvider {
    fun putToken(token: String)
    fun clearToken()
    fun getToken(): String?
    fun tokenContain(): Boolean
}

