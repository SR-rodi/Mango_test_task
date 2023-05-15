package ru.sr.mango_test_task.core.base

import android.util.Log
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

abstract class BaseViewModel <ViewState>(): ViewModel() {

    private val _loadingState =
        MutableSharedFlow<LoadingState>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    private val _viewStates = MutableStateFlow<ViewState?>(null)

    private var viewState: ViewState?
        get() = _viewStates.value
        set(value) {
            _viewStates.value = value
        }

    protected var loadingState: LoadingState
        get() = _loadingState.replayCache.last()
        set(value) {
            _loadingState.tryEmit(value)
        }

    fun viewStates() = _viewStates.asStateFlow()
    fun loadingState() = _loadingState.asSharedFlow()

    protected open fun onError(exception: Exception) {
        Log.e("Kart", exception.toString())
        loadingState = LoadingState.Error
    }

    fun onResetLoadingState() {
        loadingState = LoadingState.Start
    }

    protected inline fun scopeLaunch(
        context: CoroutineContext = EmptyCoroutineContext,
        crossinline onFinally: () -> Unit = {},
        crossinline onError: (t: Exception) -> Unit = ::onError,
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

class ViewState<ViewState>(initState: ViewState) {
    private val _viewStates = MutableStateFlow(initState)
    private var viewState: ViewState
        get() = _viewStates.value
        set(value) {
            _viewStates.value = value
        }

    fun viewStates() = _viewStates.asStateFlow()


}

