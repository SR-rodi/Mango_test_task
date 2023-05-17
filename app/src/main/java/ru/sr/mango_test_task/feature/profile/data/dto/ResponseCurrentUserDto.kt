package ru.sr.mango_test_task.feature.profile.data.dto

import com.google.gson.annotations.SerializedName

class ResponseCurrentUserDto(

    @SerializedName("profile_data")
    val profile: ProfileDto
)