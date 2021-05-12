package com.nikasov.pagingexample.data.network

import com.nikasov.pagingexample.data.network.entity.PostEntity
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/posts")
    suspend fun getPosts(): Response<List<PostEntity>>
}