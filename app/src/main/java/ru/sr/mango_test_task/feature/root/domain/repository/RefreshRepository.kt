package ru.sr.mango_test_task.feature.root.domain.repository

interface RefreshRepository {

    suspend fun refresh()
}