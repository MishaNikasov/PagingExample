package com.nikasov.pagingexample.repository

import com.nikasov.pagingexample.common.DataState
import com.nikasov.pagingexample.data.network.Api
import com.nikasov.pagingexample.data.network.entity.PostEntity
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val api: Api
){
    suspend fun getPosts(): DataState<List<PostEntity>> {
        val posts = api.getPosts()
        if (posts.isSuccessful) {
            posts.body()?.let { list ->
                return DataState.Success(list)
            }
            return DataState.Success(arrayListOf())
        } else {
            return DataState.Error(Exception())
        }
    }
}