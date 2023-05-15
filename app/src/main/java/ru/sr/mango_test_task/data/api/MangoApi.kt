package ru.sr.mango_test_task.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import ru.sr.mango_test_task.data.body.AuthorizationBody
import ru.sr.mango_test_task.data.body.CheckCodeBody
import ru.sr.mango_test_task.data.body.RegistrationBody
import ru.sr.mango_test_task.data.dto.ResponseAuthCheckCodeDto
import ru.sr.mango_test_task.data.dto.ResponseAuthorizationDto
import ru.sr.mango_test_task.data.dto.ResponseRegistrationDto

interface MangoApi {

    @POST(USERS_REGISTRATION)
    suspend fun userRegistration(@Body body: RegistrationBody): ResponseRegistrationDto

    @POST(USERS_AUTHORIZATION)
    suspend fun userAuthorization(@Body body: AuthorizationBody): ResponseAuthorizationDto

    @POST(USERS_CHECK_CODE_AUTHORIZATION)
    suspend fun userCheckAuthorizationCode(@Body body: CheckCodeBody):ResponseAuthCheckCodeDto


    private companion object {
        const val USERS_REGISTRATION = "users/register/"
        const val USERS_AUTHORIZATION= "users/send-auth-code/"
        const val USERS_CHECK_CODE_AUTHORIZATION= "users/check-auth-code/"
    }
}