package ru.sr.mango_test_task.data.dto

import com.google.gson.annotations.SerializedName

class ResponseRegistrationDto(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("user_id")
    val userId: Int
)