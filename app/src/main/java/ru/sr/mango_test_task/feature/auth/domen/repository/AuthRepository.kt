package ru.sr.mango_test_task.feature.auth.domen.repository

interface AuthRepository {

    suspend fun sendPhone(phone: String): Boolean

    suspend fun checkCode(phone: String, code: String): Boolean

    suspend fun userRegistration(phone: String, name: String, username: String)
}