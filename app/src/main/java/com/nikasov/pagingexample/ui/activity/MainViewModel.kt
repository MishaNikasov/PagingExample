package com.nikasov.pagingexample.ui.activity

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.nikasov.pagingexample.repository.PassengerRepository
import com.nikasov.pagingexample.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val passengerRepository: PassengerRepository
): BaseViewModel() {

    val passengerList = passengerRepository.getPassengers().flow.cachedIn(viewModelScope)
}