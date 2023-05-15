package ru.sr.mango_test_task.data.dto

import com.google.gson.annotations.SerializedName
import ru.sr.mango_test_task.domain.auth.model.AuthUserDomainModel

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