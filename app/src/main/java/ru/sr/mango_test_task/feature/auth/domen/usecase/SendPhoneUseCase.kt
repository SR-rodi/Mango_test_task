package ru.sr.mango_test_task.feature.auth.domen.usecase

interface SendPhoneUseCase {

    suspend fun send(phone: String): Boolean
}