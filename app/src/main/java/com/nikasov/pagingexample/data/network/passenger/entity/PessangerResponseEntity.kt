package com.nikasov.pagingexample.data.network.passenger.entity

data class PassengerResponseEntity(
    val data: List<PassengerEntity>,
    val totalPages: Int,
    val totalPassengers: Int
)