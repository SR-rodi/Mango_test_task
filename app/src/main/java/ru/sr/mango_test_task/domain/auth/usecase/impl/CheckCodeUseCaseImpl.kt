package ru.sr.mango_test_task.domain.auth.usecase.impl

import ru.sr.mango_test_task.domain.auth.model.AuthUserDomainModel
import ru.sr.mango_test_task.domain.auth.repository.AuthRepository
import ru.sr.mango_test_task.domain.auth.usecase.CheckCodeUseCase

class CheckCodeUseCaseImpl(private val repository: AuthRepository) : CheckCodeUseCase {
    override suspend fun check(phone: String, code: String): AuthUserDomainModel {
        return repository.checkCode(phone, code)
    }

}