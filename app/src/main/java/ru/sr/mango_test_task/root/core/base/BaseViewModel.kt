package ru.sr.mango_test_task.root.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel<State : BaseState>(initialState: State) : ViewModel() {

    private val _viewStates = MutableStateFlow(initialState)

    protected var viewState: State
        get() = _viewStates.value
        set(value) {
            _viewStates.value = value
        }

    fun viewStates() = _viewStates.asStateFlow()

    protected inline fun scopeLaunch(
        context: CoroutineContext = EmptyCoroutineContext,
        crossinline onError: (t: Exception) -> Unit = {},
        crossinline onFinally: () -> Unit = {},
        crossinline job: suspend () -> Unit,
    ): Job {
        return viewModelScope.launch(context) {
            try {
                job()
            } catch (e: Exception) {
                onError(e)
            } finally {
                onFinally()
            }
        }
    }
}

