package ru.sr.mango_test_task.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel<ViewState, ViewAction>(initState: ViewState) : ViewModel() {

    private val _viewStates = MutableStateFlow(initState)
    private val _viewActions =
        MutableSharedFlow<ViewAction?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    protected var viewState: ViewState
        get() = _viewStates.value
        set(value) {
            _viewStates.value = value
        }

    protected var viewAction: ViewAction?
        get() = _viewActions.replayCache.last()
        set(value) {
            _viewActions.tryEmit(value)
        }

    fun viewStates() = _viewStates.asStateFlow()
    fun viewAction() = _viewActions.asSharedFlow()

    fun onResetAction() {
        viewAction = null
    }

    protected inline fun scopeLaunch(
        context: CoroutineContext = EmptyCoroutineContext,
        crossinline onFinally: () -> Unit = {},
        crossinline onError: (t: Exception) -> Unit = {},
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

