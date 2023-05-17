package ru.sr.mango_test_task.feature.profile.data.repository

import android.net.Uri
import ru.sr.mango_test_task.feature.profile.data.database.UserDao
import ru.sr.mango_test_task.feature.profile.data.database.UserEntity
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileLocationRepository
import ru.sr.mango_test_task.feature.root.domain.provider.UserIdProvider

class ProfileLocationRepositoryImpl(
    private val dao: UserDao,
    private val userIdProvider: UserIdProvider,
) : ProfileLocationRepository {
    override suspend fun getCurrentUser(): UserProfileDomainModel? {
        val userId = userIdProvider.getUserId()
        return if (userId != null) dao.getUserById(userId)?.toDomain()
        else null

    }

    override suspend fun insertUser(user: UserProfileDomainModel) {
        dao.insertUser(user.toEntity())
    }

    override suspend fun updateUser(
        userAvatar: String?,
        name: String,
        userName: String,
        birthday: String?,
        city: String?,
        phone: String,
    ) {
        val userId = userIdProvider.getUserId()
        if (userId != null)
            dao.update(UserEntity(userId, userAvatar, birthday, city, userName, name, phone))
    }


    override suspend fun deleteUser(user: UserProfileDomainModel) {
        // dao.delete(user.toEntity())
    }
}

fun UserProfileDomainModel.toEntity() = UserEntity(
    id, avatar, birthday, city, username, name, phone
)
