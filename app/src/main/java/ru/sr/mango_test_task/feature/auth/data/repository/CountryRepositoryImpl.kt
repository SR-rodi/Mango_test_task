package ru.sr.mango_test_task.feature.auth.data.repository

import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.feature.auth.domen.repository.CountryRepository

class CountryRepositoryImpl : CountryRepository {
    private val map = mapOf(
        R.drawable.auth_ic_flag_rus to PhoneFormat("+7","(XXX)-XXX-XX-XX"),
        R.drawable.auth_ic_flag_ger to PhoneFormat("+49","(XXXX)-XXX-XXX"),
        R.drawable.auth_ic_flag_avs to PhoneFormat("+43","XX-XX-XX-XX-XX")
    )

    override fun getCountry(): Map<Int, PhoneFormat> {
        return map
    }
}

class PhoneFormat(
    val code: String,
    val format: String,
)