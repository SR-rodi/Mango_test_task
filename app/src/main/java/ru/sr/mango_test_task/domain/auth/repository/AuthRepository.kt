package ru.sr.mango_test_task.domain.auth.repository

import ru.sr.mango_test_task.domain.auth.model.AuthUserDomainModel

interface AuthRepository {

    suspend fun sendPhone(phone: String):Boolean

    suspend fun checkCode(phone: String, code: String): AuthUserDomainModel
}

