package ru.sr.mango_test_task.data.dto

import com.google.gson.annotations.SerializedName

class ResponseAuthorizationDto(
    @SerializedName("is_success")
    val isSuccess: Boolean
)