package com.nikasov.pagingexample.common

sealed class UiState {
    data class Error(val exception: Exception): UiState()
    data class Loading(val inProgress: Boolean): UiState()
    object Successes: UiState()
    object Empty: UiState()
}