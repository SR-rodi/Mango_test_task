package ru.sr.mango_test_task.feature.root.data.dto

data class ResponseRefresh(
    val access_token: String,
    val refresh_token: String,
    val user_id: Int
)