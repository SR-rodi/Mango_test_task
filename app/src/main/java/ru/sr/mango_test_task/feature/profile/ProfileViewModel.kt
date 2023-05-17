package ru.sr.mango_test_task.feature.profile

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.core.base.BaseViewModel
import ru.sr.mango_test_task.feature.profile.domain.usecase.GetUserUseCase
import ru.sr.mango_test_task.feature.profile.domain.usecase.impl.UpdateUserUseCase

class ProfileViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val userUseCase: UpdateUserUseCase
) : BaseViewModel<ProfileState, ProfileAction>(ProfileState()) {

    private var avatarUriUpdate: Uri? = null

    fun getUser() = scopeLaunch(context = Dispatchers.IO) {
        val a = getUserUseCase.get()
        Log.e("Kart", "${a.toString()}")
    }

    fun saveUri(uri: Uri) {
            avatarUriUpdate = uri
    }

    fun userUpdate() {
        scopeLaunch {
            userUseCase.update(avatarUriUpdate)
        }

    }
}

data class ProfileState(
    val isLoading: Boolean = false,
)

sealed interface ProfileAction {

}