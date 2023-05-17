package ru.sr.mango_test_task.feature.auth.domen.usecase

import ru.sr.mango_test_task.feature.auth.data.PhoneFormat

interface CountryUseCase {

    fun getCountry(): Map<Int, PhoneFormat>
}