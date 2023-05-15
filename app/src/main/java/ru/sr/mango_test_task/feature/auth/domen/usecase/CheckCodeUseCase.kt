package ru.sr.mango_test_task.feature.auth.domen.usecase

import ru.sr.mango_test_task.feature.auth.domen.model.AuthUserDomainModel

interface CheckCodeUseCase {

    suspend fun check(phone: String, code: String): AuthUserDomainModel
}