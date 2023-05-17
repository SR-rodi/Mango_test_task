package ru.sr.mango_test_task.feature.profile.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.sr.mango_test_task.feature.profile.data.database.MangoDatabase
import ru.sr.mango_test_task.feature.profile.data.database.UserDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) = Room.databaseBuilder(
        context,
        MangoDatabase::class.java, "Mango"
    ).build()

    @Provides
    @Singleton
    fun provideUserDao(database: MangoDatabase): UserDao = database.userDao()

}