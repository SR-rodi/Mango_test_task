package ru.sr.mango_test_task.feature.auth.domen.usecase.impl

import ru.sr.mango_test_task.feature.auth.domen.model.AuthUserDomainModel
import ru.sr.mango_test_task.feature.auth.domen.repository.AuthRepository
import ru.sr.mango_test_task.feature.auth.domen.usecase.RegistrationUseCase

class RegistrationUseCaseImpl(private val repository: AuthRepository) : RegistrationUseCase {
    override suspend fun registration(
        phone: String,
        name: String,
        username: String,
    ): AuthUserDomainModel {
        return repository.userRegistration(phone, name, username)
    }
}