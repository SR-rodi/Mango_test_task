package ru.sr.mango_test_task.feature.auth.data.repository

import ru.sr.mango_test_task.R
import ru.sr.mango_test_task.feature.auth.domen.repository.CountryRepository

class CountryRepositoryImpl : CountryRepository {
    private val map = mapOf(
        R.drawable.auth_ic_flag_rus to "+7",
        R.drawable.auth_ic_flag_ger to "+49",
        R.drawable.auth_ic_flag_avs to "+43"
    )

    override fun getCountry(): Map<Int, String> {
        return map
    }
}