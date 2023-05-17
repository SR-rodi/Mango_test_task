package ru.sr.mango_test_task.feature.profile.presentation

data class UserProfileUIModel(
    val id: String,
    val avatar: String?,
    val birthday: String?,
    val city: String?,
    val username: String,
    val name: String,
    val phone: String,
)