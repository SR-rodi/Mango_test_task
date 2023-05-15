package ru.sr.mango_test_task.feature.auth.domen.usecase

import ru.sr.mango_test_task.feature.auth.domen.model.AuthUserDomainModel

interface RegistrationUseCase {
    suspend fun registration(phone: String, name: String, username: String): AuthUserDomainModel
}