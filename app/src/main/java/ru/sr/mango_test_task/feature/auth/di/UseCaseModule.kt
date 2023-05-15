package ru.sr.mango_test_task.feature.auth.di

import dagger.Module
import dagger.Provides
import ru.sr.mango_test_task.feature.auth.domen.repository.AuthRepository
import ru.sr.mango_test_task.feature.auth.domen.usecase.CheckCodeUseCase
import ru.sr.mango_test_task.feature.auth.domen.usecase.RegistrationUseCase
import ru.sr.mango_test_task.feature.auth.domen.usecase.SendPhoneUseCase
import ru.sr.mango_test_task.feature.auth.domen.usecase.impl.CheckCodeUseCaseImpl
import ru.sr.mango_test_task.feature.auth.domen.usecase.impl.RegistrationUseCaseImpl
import ru.sr.mango_test_task.feature.auth.domen.usecase.impl.SendPhoneUseCaseImpl
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun providerSendPhoneUseCase(repository: AuthRepository): SendPhoneUseCase =
        SendPhoneUseCaseImpl(repository)

    @Provides
    @Singleton
    fun providerCheckCodeUseCase(repository: AuthRepository): CheckCodeUseCase =
        CheckCodeUseCaseImpl(repository)

    @Provides
    @Singleton
    fun providerRegistrationUseCase(repository: AuthRepository): RegistrationUseCase =
        RegistrationUseCaseImpl(repository)
}