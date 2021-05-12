package com.nikasov.pagingexample.data.network.entity

data class PostEntity(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)