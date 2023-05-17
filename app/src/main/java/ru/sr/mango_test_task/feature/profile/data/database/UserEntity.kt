package ru.sr.mango_test_task.feature.profile.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel

@Entity(tableName = "user")
class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "avatar") val avatar: String?,
    @ColumnInfo(name = "birthday") val birthday: String?,
    @ColumnInfo(name = "city") val city: String?,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "phone") val phone: String,
) {
    fun toDomain() = UserProfileDomainModel(id, avatar, birthday, city, username, name, phone,)
}