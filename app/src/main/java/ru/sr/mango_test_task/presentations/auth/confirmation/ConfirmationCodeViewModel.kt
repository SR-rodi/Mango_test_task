package ru.sr.mango_test_task.presentations.auth.confirmation

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import ru.sr.mango_test_task.domain.auth.usecase.CheckCodeUseCase
import ru.sr.mango_test_task.root.core.base.BaseViewModel

class ConfirmationCodeViewModel(
    private val checkCodeUseCase: CheckCodeUseCase,
) : BaseViewModel() {

    fun checkCode(phone: String, code: String) =
        scopeLaunch(context = Dispatchers.IO, onError = { Log.e("Kart", it.toString()) }) {
            Log.e("Kart", "Test =  ${checkCodeUseCase.check(phone, code).accessToken}")
        }

}