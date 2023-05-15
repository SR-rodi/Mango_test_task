package ru.sr.mango_test_task.feature.auth.data.dto

import com.google.gson.annotations.SerializedName
import ru.sr.mango_test_task.feature.auth.domen.model.AuthUserDomainModel

class ResponseAuthCheckCodeDto(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("is_user_exists")
    val isUserExists: Boolean,
) {
    fun toAuthUserDomain() = AuthUserDomainModel(accessToken, refreshToken, userId,isUserExists)
}