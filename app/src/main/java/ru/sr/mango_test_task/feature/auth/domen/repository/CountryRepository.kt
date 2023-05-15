package ru.sr.mango_test_task.feature.auth.domen.repository

interface CountryRepository {

    fun getCountry(): Map<Int, String>
}