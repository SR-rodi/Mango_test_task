package ru.sr.mango_test_task.feature.profile

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.net.Uri
import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.sr.mango_test_task.core.base.BaseViewModel
import ru.sr.mango_test_task.core.extension.toUi
import ru.sr.mango_test_task.feature.profile.domain.usecase.GetUserUseCase
import ru.sr.mango_test_task.feature.profile.domain.usecase.impl.UpdateUserUseCase
import ru.sr.mango_test_task.feature.profile.presentation.UserProfileUIModel
import java.lang.Exception
import java.util.Date

class ProfileViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val userUseCase: UpdateUserUseCase,
) : BaseViewModel<ProfileState, ProfileAction>(ProfileState()) {

    private var avatarUriUpdate: Uri? = null

    init {
        getUser()

    }

    private fun getUser() = scopeLaunch(context = Dispatchers.IO) {
        viewState = viewState.copy(user = getUserUseCase.get().toUi())
    }

    fun saveUri(uri: Uri) {
        avatarUriUpdate = uri
    }

    fun userUpdate(birthday: String, city: String) {
        scopeLaunch(context = Dispatchers.IO) {
            viewState = viewState
                .copy(
                    user = viewState.user?.copy(birthday = birthday, city = city),
                    isLoading = true,
                    isError = false
                )
            val newAvatar = userUseCase
                .update(
                    avatarUriUpdate,
                    viewState.user?.name?:"",
                    viewState.user?.username?:"",
                    birthday,
                    city,
                    viewState.user?.phone?:"",
                    viewState.user?.avatar
                )
            viewAction = ProfileAction.ShowSuccessToast

            viewState = viewState.copy(
                user = viewState.user?.copy(avatar = newAvatar),
                isLoading = false,
                isError = false
            )
        }
    }

    fun onError (exception: Exception){
        viewState = viewState.copy(
            isLoading = false,
            isError = true
        )
    }
}

data class ProfileState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val user: UserProfileUIModel? = null,
)

sealed interface ProfileAction {
    object ShowSuccessToast : ProfileAction
}
