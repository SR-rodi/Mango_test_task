package ru.sr.mango_test_task.feature.profile.data.database

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel

@Database(entities = [UserEntity::class], version = 1)
abstract class MangoDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

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
    fun toDomain() = UserProfileDomainModel(id, avatar, birthday, city, username, name  ,phone,)
}

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id IN (:userId)")
    fun getUserById(userId: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(users: UserEntity)

    @Update
    fun update(users: UserEntity)

}