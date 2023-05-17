package ru.sr.mango_test_task.feature.profile.data.body

class UpdateUserBody(
    val avatar: Avatar?,
    val birthday: String? = null,
    val city: String? = null,
    val name: String ,
    val username: String,
)