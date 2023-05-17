package ru.sr.mango_test_task.feature.profile.data.dto

import com.google.gson.annotations.SerializedName
import ru.sr.mango_test_task.core.extension.simpleDateFormat
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel

class ProfileDto(
    private val avatars: AvatarsDto?,
    private val birthday: String?,
    private val city: String?,
    @SerializedName("completed_task")
    private val id: Int,
    private val name: String,
    private val phone: String,
    private val username: String,
) {
    fun toDomain() = UserProfileDomainModel(
        id.toString(),
        "https://plannerok.ru/${avatars?.avatar}",
        birthday?.simpleDateFormat("yyyy-MM-dd", "dd.MM.yyyy"),
        city,
        username,
        name,
        phone
    )
}