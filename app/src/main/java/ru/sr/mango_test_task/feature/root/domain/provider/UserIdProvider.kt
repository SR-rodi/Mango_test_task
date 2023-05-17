package ru.sr.mango_test_task.feature.root.domain.provider

interface UserIdProvider {
    fun putUserId(userId: String?)
    fun clearUserId()
    fun getUserId(): String?
}

