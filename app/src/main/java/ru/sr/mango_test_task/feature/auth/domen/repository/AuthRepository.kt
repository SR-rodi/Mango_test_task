package ru.sr.mango_test_task.feature.auth.domen.repository

import ru.sr.mango_test_task.feature.auth.domen.model.AuthUserDomainModel

interface AuthRepository {

    suspend fun sendPhone(phone: String):Boolean

    suspend fun checkCode(phone: String, code: String): AuthUserDomainModel

    suspend fun userRegistration(phone: String, name: String, username: String): AuthUserDomainModel
}

