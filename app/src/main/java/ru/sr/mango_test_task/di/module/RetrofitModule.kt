package ru.sr.mango_test_task.di.module

import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.sr.mango_test_task.feature.auth.data.api.MangoApi
import javax.inject.Singleton

@dagger.Module
class RetrofitModule {

    @Provides
    @Singleton
    fun providerInterceptorLogger(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providerRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): MangoApi = retrofit.create()

    companion object {
        private const val BASE_URL = "https://plannerok.ru/api/v1/"
    }
}