package ru.sr.mango_test_task.feature.profile.data.repository

import ru.sr.mango_test_task.feature.profile.data.database.UserDao
import ru.sr.mango_test_task.feature.profile.data.database.UserEntity
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileLocationRepository

class ProfileLocationRepositoryImpl(private val dao: UserDao) : ProfileLocationRepository {
    override suspend fun getCurrentUser(): UserProfileDomainModel? {
        val users = dao.getAll()
        return if (users.isNotEmpty()) users.first().toDomain() else null
    }

    override suspend fun insertUser(user: UserProfileDomainModel) {
      //  dao.insertAll(user.toEntity())
    }

    override suspend fun deleteUser(user: UserProfileDomainModel) {
       // dao.delete(user.toEntity())
    }
}

fun UserProfileDomainModel.toEntity() = UserEntity(
    id, avatar, birthday, city, username, phone
)
