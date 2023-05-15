package ru.sr.mango_test_task.domain.auth.usecase

interface SendPhoneUseCase {

    suspend fun send(phone: String):Boolean
}