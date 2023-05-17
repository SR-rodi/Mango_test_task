package ru.sr.mango_test_task.feature.profile.data.dto

import com.google.gson.annotations.SerializedName
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel

class ProfileDto(
    val avatar: String,
    val avatars: AvatarsDto,
    val birthday: String,
    val city: String,
    @SerializedName("completed_task")
    val completedTask: Int,
    val created: String,
    val id: Int,
    val instagram: String,
    val last: String,
    val name: String,
    val online: Boolean,
    val phone: String,
    val status: String,
    val username: String,
    val vk: String
){
    fun toDomain() = UserProfileDomainModel(
        id, avatar, birthday, city, username, phone
    )
}