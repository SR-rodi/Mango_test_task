package ru.sr.mango_test_task.feature.profile.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id IN (:userId)")
    fun getUserById(userId: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(users: UserEntity)

    @Update
    fun update(users: UserEntity)
}