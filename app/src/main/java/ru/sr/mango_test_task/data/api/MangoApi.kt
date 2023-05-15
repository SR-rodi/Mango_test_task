package ru.sr.mango_test_task.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import ru.sr.mango_test_task.data.body.RegistrationBody
import ru.sr.mango_test_task.data.dto.ResponseRegistration

interface MangoApi {

    @POST(USER_REGISTRATION)
    suspend fun userRegistration(@Body body: RegistrationBody): ResponseRegistration

    private companion object {
        const val USER_REGISTRATION = "users/register/"
    }
}