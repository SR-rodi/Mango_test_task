package ru.sr.mango_test_task.feature.auth.domen.usecase.impl

import ru.sr.mango_test_task.feature.auth.data.PhoneFormat
import ru.sr.mango_test_task.feature.auth.domen.repository.CountryRepository
import ru.sr.mango_test_task.feature.auth.domen.usecase.CountryUseCase

class CountryUseCaseImpl(private val repository: CountryRepository) : CountryUseCase {

    override fun getCountry(): Map<Int, PhoneFormat> {
        return repository.getCountry()
    }
}