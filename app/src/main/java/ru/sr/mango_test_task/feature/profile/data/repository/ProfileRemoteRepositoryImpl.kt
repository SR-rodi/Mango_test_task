package ru.sr.mango_test_task.feature.profile.data.repository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import android.util.Log
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import ru.sr.mango_test_task.feature.profile.data.api.ProfileApi
import ru.sr.mango_test_task.feature.profile.data.body.Avatar
import ru.sr.mango_test_task.feature.profile.data.body.UpdateUserBody
import ru.sr.mango_test_task.feature.profile.data.dto.ResponseUpdate
import ru.sr.mango_test_task.feature.profile.domain.model.UserProfileDomainModel
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileRemoteRepository
import ru.sr.mango_test_task.feature.root.domain.encoder.Base64Encoder
import java.io.ByteArrayOutputStream
import java.io.InputStream

class ProfileRemoteRepositoryImpl(
    private val api:ProfileApi,
    private val encoder: Base64Encoder
) :ProfileRemoteRepository{
    override suspend fun getCurrentUser(): UserProfileDomainModel {
       return api.getCurrentUser().profile.toDomain()
    }

    override suspend fun updateUserInfo(avatar: Uri?) {

        if (avatar != null) {
            Log.e("Kart","base64 = ${encoder.encodeUriToString(avatar)}")
        }

    }
}