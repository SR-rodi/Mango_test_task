package ru.sr.mango_test_task.feature.profile.domain.usecase.impl

import android.net.Uri
import ru.sr.mango_test_task.feature.profile.domain.repository.ProfileRemoteRepository

interface UpdateUserUseCase {

   suspend fun update(userAvatar: Uri?)

}

class UpdateUserUseCaseImpl(
    private val repository: ProfileRemoteRepository,
) : UpdateUserUseCase {

    override suspend fun update(userAvatar: Uri?) {
        repository.updateUserInfo(userAvatar)
    }

}