package ru.sr.mango_test_task.root.di.module

import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.sr.mango_test_task.data.api.MangoApi
import javax.inject.Singleton

@dagger.Module
class RetrofitModule {

    @Provides
    @Singleton
    fun providerRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): MangoApi = retrofit.create()

    companion object {
        private const val BASE_URL = "https://plannerok.ru/"
    }
}