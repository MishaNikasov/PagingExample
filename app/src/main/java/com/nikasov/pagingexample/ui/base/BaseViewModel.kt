package com.nikasov.pagingexample.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikasov.pagingexample.common.UiState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


open class BaseViewModel: ViewModel() {
    protected val _uiState = MutableLiveData<UiState>(UiState.Empty)
    val uiState : LiveData<UiState> = _uiState

    val exceptionHandler = CoroutineExceptionHandler { _: CoroutineContext, _: Throwable ->

    }

    fun launchRequest(action: (() -> Job)) {
        _uiState.postValue(UiState.Loading(true))
        action.invoke()
        _uiState.postValue(UiState.Loading(false))
    }
}