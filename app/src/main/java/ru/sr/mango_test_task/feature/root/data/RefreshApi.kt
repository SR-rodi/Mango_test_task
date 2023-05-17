package ru.sr.mango_test_task.feature.root.data

import retrofit2.http.Body
import retrofit2.http.POST

interface RefreshApi {

    @POST(REFRESH)
    suspend fun refreshToken(@Body body: RefreshBody): ResponseRefresh

    private companion object {
        const val REFRESH = "users/refresh-token/"
    }
}