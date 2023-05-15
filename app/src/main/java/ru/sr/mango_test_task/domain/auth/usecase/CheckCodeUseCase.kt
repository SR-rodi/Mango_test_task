package ru.sr.mango_test_task.domain.auth.usecase

import ru.sr.mango_test_task.domain.auth.model.AuthUserDomainModel

interface CheckCodeUseCase {

    suspend fun check(phone: String, code: String): AuthUserDomainModel
}