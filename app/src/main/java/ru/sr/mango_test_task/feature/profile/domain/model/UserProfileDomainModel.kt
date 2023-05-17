package ru.sr.mango_test_task.feature.profile.domain.model

data class UserProfileDomainModel (
    val id: Int,
    val avatar:String,
    val birthday: String,
    val city: String,
    val username: String,
    val phone: String,
)