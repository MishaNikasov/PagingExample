package com.nikasov.pagingexample.data.network.passenger

import com.nikasov.pagingexample.data.network.passenger.entity.PassengerResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PassengerApi {

    @GET("passenger")
    suspend fun getPassengers(
        @Query("page") page: Int,
        @Query("size") size: Int = 10
    ): Response<PassengerResponseEntity>
}