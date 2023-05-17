package ru.sr.mango_test_task.feature.auth.domen.usecase

interface RegistrationUseCase {

    suspend fun registration(phone: String, name: String, username: String)
}