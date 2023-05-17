package ru.sr.mango_test_task.feature.profile.data.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import ru.sr.mango_test_task.feature.profile.data.body.UpdateUserBody
import ru.sr.mango_test_task.feature.profile.data.dto.ResponseCurrentUserDto
import ru.sr.mango_test_task.feature.profile.data.dto.ResponseUpdate

interface ProfileApi {

    @GET(USER_ME)
    suspend fun getCurrentUser(): ResponseCurrentUserDto

    @PUT(USER_ME)
    suspend fun updateUser(@Body body: UpdateUserBody):ResponseUpdate

    private companion object {
        const val USER_ME = "users/me/"
    }
}