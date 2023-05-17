package ru.sr.mango_test_task.feature.profile.presentation

import android.net.Uri
import android.util.Log
import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.core.base.BaseViewModel
import ru.sr.mango_test_task.core.extension.toUi
import ru.sr.mango_test_task.feature.profile.domain.usecase.GetUserUseCase
import ru.sr.mango_test_task.feature.profile.domain.usecase.UpdateUserUseCase
import ru.sr.mango_test_task.feature.profile.presentation.model.ProfileAction
import ru.sr.mango_test_task.feature.profile.presentation.model.ProfileState

class ProfileViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val userUseCase: UpdateUserUseCase,
) : BaseViewModel<ProfileState, ProfileAction>(ProfileState()) {

    init {
        getUser()
    }

    private fun getUser() = scopeLaunch(context = Dispatchers.IO) {
        viewState = viewState.copy(user = getUserUseCase.get().toUi())
    }

    fun saveUri(uri: Uri) {
        viewState = viewState.copy(avatarUriUpdate = uri)
    }

    fun userUpdate(birthday: String, city: String) {
        scopeLaunch(context = Dispatchers.IO, onError = ::onError) {
            updateLoading(birthday, city)
            val newAvatar = startUpdate(birthday, city)
            viewAction = ProfileAction.ShowSuccessToast
            successUpdate(newAvatar)
        }
    }

    private fun updateLoading(birthday: String, city: String) {
        val updateUser = viewState.user?.copy(birthday = birthday, city = city)
        viewState = viewState.copy(user = updateUser, isLoading = true, isError = false)
    }

    private suspend fun startUpdate(birthday: String, city: String): String? {
        return userUseCase.update(
            userAvatar = viewState.avatarUriUpdate,
            name = viewState.user?.name ?: "",
            userName = viewState.user?.username ?: "",
            birthday = birthday,
            city = city,
            phone = viewState.user?.phone ?: "",
            currentAvatar = viewState.user?.avatar
        )
    }

    private fun successUpdate(newAvatar: String?) {
        viewAction = ProfileAction.ShowSuccessToast
        viewState = viewState.copy(
            user = viewState.user?.copy(avatar = newAvatar),
            isLoading = false,
            isError = false
        )
    }

    private fun onError(exception: Exception) {
        Log.e("Kart", exception.toString())
        viewState = viewState.copy(
            isLoading = false,
            isError = true
        )
    }
}