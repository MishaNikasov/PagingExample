package com.nikasov.pagingexample.data.network.passenger

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nikasov.pagingexample.data.network.passenger.entity.PassengerEntity
import retrofit2.HttpException

class PassengerPageSource(
    private val passengerApi: PassengerApi
): PagingSource<Int, PassengerEntity>() {

    override fun getRefreshKey(state: PagingState<Int, PassengerEntity>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PassengerEntity> {
        val page: Int = params.key ?: 1
        val size: Int = params.loadSize

        val response = passengerApi.getPassengers(page, size)

        return if (response.isSuccessful) {
            val passengers = checkNotNull(response.body())
            val nextKey = if (passengers.data.size < size) null else page + 1
            val prevKey = if (page == 1) null else page - 1
            LoadResult.Page(passengers.data, prevKey, nextKey)
        } else {
            LoadResult.Error(HttpException(response))
        }
    }
}