package ru.sr.mango_test_task.feature.auth.domen.usecase

interface CheckCodeUseCase {

    suspend fun check(phone: String, code: String): Boolean
}