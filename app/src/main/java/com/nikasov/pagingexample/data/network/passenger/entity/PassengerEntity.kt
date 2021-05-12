package com.nikasov.pagingexample.data.network.passenger.entity

data class PassengerEntity(
    val __v: Int,
    val _id: String,
//    val airline: Airline,
    val name: String,
    val trips: Int
)

data class Airline(
    val country: String,
    val established: String,
    val head_quaters: String,
    val id: Int,
    val logo: String,
    val name: String,
    val slogan: String,
    val website: String
)