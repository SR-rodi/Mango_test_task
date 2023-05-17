package ru.sr.mango_test_task.feature.auth.domen.usecase.impl

import ru.sr.mango_test_task.feature.auth.domen.repository.AuthRepository
import ru.sr.mango_test_task.feature.auth.domen.usecase.SendPhoneUseCase

class SendPhoneUseCaseImpl(private val repository: AuthRepository) : SendPhoneUseCase {

    override suspend fun send(phone: String): Boolean {
        return repository.sendPhone(phone)
    }
}