package ru.sr.mango_test_task.feature.root.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import ru.sr.mango_test_task.feature.root.data.body.RefreshBody
import ru.sr.mango_test_task.feature.root.data.dto.ResponseRefresh

interface RefreshApi {

    @POST(REFRESH)
    suspend fun refreshToken(@Body body: RefreshBody): ResponseRefresh

    private companion object {
        const val REFRESH = "users/refresh-token/"
    }
}