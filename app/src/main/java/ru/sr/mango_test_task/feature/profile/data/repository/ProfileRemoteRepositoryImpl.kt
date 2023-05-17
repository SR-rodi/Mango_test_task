package ru.sr.mango_test_task.feature.profile.data.repository

import android.net.Uri
import ru.sr.mango_test_task.core.extension.simpleDateFormat
import ru.sr.mango_test_task.feature.profile.data.api.ProfileApi
import ru.sr.mango_test_task.feature.profile.data.body.Avatar
import ru.sr.mango_test_task.feature.profile.data.body.UpdateUserBody
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileRemoteRepository
import ru.sr.mango_test_task.feature.root.domain.encoder.Base64Encoder

class ProfileRemoteRepositoryImpl(
    private val api: ProfileApi,
    private val encoder: Base64Encoder,
) : ProfileRemoteRepository {

    override suspend fun getCurrentUser(): UserProfileDomainModel {
        val user = api.getCurrentUser().profile
        return user.toDomain()
    }

    override suspend fun updateUserInfo(
        avatar: Uri?,
        name: String,
        userName: String,
        birthday: String?,
        city: String?,
    ):String? {
        val newAvatar = if (avatar != null)
            Avatar(encoder.encodeUriToString(avatar), "$PREFIX_NAME$userName")
        else null

       return api.updateUser(
            UpdateUserBody(
                name = name,
                username = userName,
                avatar = newAvatar,
                birthday = birthday?.simpleDateFormat("dd.MM.yyyy","yyyy-MM-dd"),
                city = city
            )
        ).avatars?.avatar
    }

   private companion object{
       const val PREFIX_NAME = "avatra_"
   }
}