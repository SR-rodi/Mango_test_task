package ru.sr.mango_test_task.feature.auth.domen.usecase

interface CountryUseCase {
    fun getCountry(): Map<Int, String>
}