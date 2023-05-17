package ru.sr.mango_test_task.feature.profile.data.database

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel

@Database(entities = [UserEntity::class], version = 1)
abstract class MangoDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

@Entity(tableName = "user")
class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")  val id: Int,
    @ColumnInfo(name = "avatar")  val avatar: String,
    @ColumnInfo(name = "birthday")  val birthday: String,
    @ColumnInfo(name = "city")  val city: String,
    @ColumnInfo(name = "username")  val username: String,
    @ColumnInfo(name = "phone")  val phone: String,
) {
    fun toDomain() = UserProfileDomainModel(id, avatar, birthday, city, username, phone)
}

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<UserEntity>

/*    @Insert
    fun insertAll(users: UserEntity)

    @Delete
    fun delete(user: UserEntity)*/
}