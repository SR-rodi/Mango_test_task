package ru.sr.mango_test_task.feature.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import ru.sr.mango_test_task.core.base.BaseViewModel
import ru.sr.mango_test_task.feature.profile.domain.usecase.GetUserUseCase

class ProfileViewModel(
    private val getUserUseCase: GetUserUseCase
) : BaseViewModel<ProfileState,ProfileAction>(ProfileState()) {

    fun getUser() =scopeLaunch(context = Dispatchers.IO) {
       val a =  getUserUseCase.get()
        Log.e("Kart","${a.toString()}")
    }
}

data class ProfileState(
    val isLoading:Boolean= false
)

sealed interface ProfileAction{

}