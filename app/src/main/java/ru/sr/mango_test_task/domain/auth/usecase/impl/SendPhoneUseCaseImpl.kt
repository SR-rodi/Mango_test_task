package ru.sr.mango_test_task.domain.auth.usecase.impl

import ru.sr.mango_test_task.domain.auth.repository.AuthRepository
import ru.sr.mango_test_task.domain.auth.usecase.SendPhoneUseCase

class SendPhoneUseCaseImpl(private val repository: AuthRepository) : SendPhoneUseCase {
    override suspend fun send(phone: String): Boolean {
       return repository.sendPhone(phone)
    }
}