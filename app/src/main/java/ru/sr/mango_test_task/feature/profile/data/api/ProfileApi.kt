package ru.sr.mango_test_task.feature.profile.data.api

import retrofit2.http.GET
import retrofit2.http.POST
import ru.sr.mango_test_task.feature.profile.data.dto.ResponseCurrentUserDto

interface ProfileApi {

    @GET(USER_ME)
    suspend fun getCurrentUser(): ResponseCurrentUserDto

    @POST(USER_ME)
    suspend fun updateUser()

    private companion object {
        const val USER_ME = "users/me/"
    }
}