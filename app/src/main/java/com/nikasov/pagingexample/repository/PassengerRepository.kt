package com.nikasov.pagingexample.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.nikasov.pagingexample.data.network.passenger.PassengerApi
import com.nikasov.pagingexample.data.network.passenger.PassengerPageSource
import javax.inject.Inject

class PassengerRepository @Inject constructor(
    private val passengerApi: PassengerApi
) {
    fun getPassengers() = Pager(
        config = PagingConfig(
            pageSize = 10,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            PassengerPageSource(passengerApi)
        }
    )
}