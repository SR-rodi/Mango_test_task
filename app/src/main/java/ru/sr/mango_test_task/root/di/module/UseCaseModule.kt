package ru.sr.mango_test_task.root.di.module

import dagger.Module
import dagger.Provides
import ru.sr.mango_test_task.domain.auth.repository.AuthRepository
import ru.sr.mango_test_task.domain.auth.usecase.CheckCodeUseCase
import ru.sr.mango_test_task.domain.auth.usecase.SendPhoneUseCase
import ru.sr.mango_test_task.domain.auth.usecase.impl.CheckCodeUseCaseImpl
import ru.sr.mango_test_task.domain.auth.usecase.impl.SendPhoneUseCaseImpl
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
}