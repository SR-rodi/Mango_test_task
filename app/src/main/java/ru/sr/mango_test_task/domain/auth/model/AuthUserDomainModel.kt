package ru.sr.mango_test_task.domain.auth.model

class AuthUserDomainModel(
    val accessToken: String,
    val refreshToken: String,
    val userId: Int,
    val isUserExists: Boolean,
)