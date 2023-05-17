package ru.sr.mango_test_task.feature.profile.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class MangoDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}