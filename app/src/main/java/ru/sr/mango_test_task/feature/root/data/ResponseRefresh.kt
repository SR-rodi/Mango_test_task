package ru.sr.mango_test_task.feature.root.data

data class ResponseRefresh(
    val access_token: String,
    val refresh_token: String,
    val user_id: Int
)