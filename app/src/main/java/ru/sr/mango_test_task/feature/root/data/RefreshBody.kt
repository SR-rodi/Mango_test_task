package ru.sr.mango_test_task.feature.root.data

import com.google.gson.annotations.SerializedName

class RefreshBody(
    @SerializedName("refresh_token")
    val refreshToken: String,
)