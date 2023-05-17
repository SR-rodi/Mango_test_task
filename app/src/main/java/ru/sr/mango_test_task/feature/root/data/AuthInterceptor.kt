package ru.sr.mango_test_task.feature.root.data

import okhttp3.Interceptor
import okhttp3.Response
import ru.sr.mango_test_task.feature.root.domain.provider.AccessTokenProvider

class AuthInterceptor(private val tokenProvider: AccessTokenProvider) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val token = if (tokenProvider.getToken() != null) "Bearer ${tokenProvider.getToken()}"
        else ""
        val request = chain.request().newBuilder()
            .addHeader("Authorization", token)
            .build()
        return chain.proceed(request)
    }
}