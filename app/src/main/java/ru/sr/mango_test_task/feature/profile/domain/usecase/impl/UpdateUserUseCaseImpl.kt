package ru.sr.mango_test_task.feature.profile.domain.usecase.impl

import android.net.Uri
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileLocationRepository
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileRemoteRepository
import ru.sr.mango_test_task.feature.profile.domain.usecase.UpdateUserUseCase

class UpdateUserUseCaseImpl(
    private val remoteRepository: ProfileRemoteRepository,
    private val locationRepository: ProfileLocationRepository
) : UpdateUserUseCase {

    override suspend fun update(
        userAvatar: Uri?,
        name: String,
        userName: String,
        birthday: String?,
        city: String?,
        phone:String,
        currentAvatar:String?,
    ): String? {
       var newAvatar =  remoteRepository.updateUserInfo(userAvatar, name, userName,birthday,city)
        newAvatar =  if (newAvatar!= null) "https://plannerok.ru/$newAvatar" else currentAvatar
        locationRepository.updateUser(newAvatar, name, userName,birthday,city,phone)
        return newAvatar
    }
}