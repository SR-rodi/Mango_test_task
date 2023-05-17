package ru.sr.mango_test_task.feature.auth.domen.repository

import ru.sr.mango_test_task.feature.auth.data.PhoneFormat

interface CountryRepository {

    fun getCountry(): Map<Int, PhoneFormat>
}