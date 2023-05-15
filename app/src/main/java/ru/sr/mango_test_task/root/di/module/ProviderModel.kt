package ru.sr.mango_test_task.root.di.module

import android.content.Context
import ru.sr.mango_test_task.data.provider.TokenProviderImpl
import ru.sr.mango_test_task.domain.provider.TokenProvider

@dagger.Module
class ProviderModel {

    fun providerTokenProvider(context: Context):TokenProvider = TokenProviderImpl(context)
}