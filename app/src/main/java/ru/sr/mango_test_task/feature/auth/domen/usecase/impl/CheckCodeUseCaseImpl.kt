package ru.sr.mango_test_task.feature.auth.domen.usecase.impl

import ru.sr.mango_test_task.feature.auth.domen.repository.AuthRepository
import ru.sr.mango_test_task.feature.auth.domen.usecase.CheckCodeUseCase

class CheckCodeUseCaseImpl(private val repository: AuthRepository) : CheckCodeUseCase {

    override suspend fun check(phone: String, code: String) = repository.checkCode(phone, code)
}