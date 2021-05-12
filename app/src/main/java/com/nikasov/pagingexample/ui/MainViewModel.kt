package com.nikasov.pagingexample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nikasov.pagingexample.common.DataState
import com.nikasov.pagingexample.common.UiState
import com.nikasov.pagingexample.data.network.entity.PostEntity
import com.nikasov.pagingexample.repository.PostRepository
import com.nikasov.pagingexample.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val postRepository: PostRepository
): BaseViewModel() {

    val postList = MutableLiveData<List<PostEntity>>()

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            _uiState.postValue(UiState.Loading(true))
            when (val dataResult = postRepository.getPosts()) {
                is DataState.Success -> {
                    postList.postValue(dataResult.data)
                }
                else -> {
                    _uiState.postValue(UiState.Error(Exception()))
                }
            }
            _uiState.postValue(UiState.Loading(false))
        }
    }
}