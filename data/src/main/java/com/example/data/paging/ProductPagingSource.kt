package com.example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.api.ProductsApiService
import com.example.domain.models.Product
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

private const val BASE_STARTING_PAGE_INDEX = 0

class ProductPagingSource(private val service: ProductsApiService): PagingSource<Int, Product>() {

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val position = params.key ?: BASE_STARTING_PAGE_INDEX

        return try {
            val response = service.loadProducts(position, params.loadSize)
            val data = response.body() ?: throw IOException(
                JSONObject(
                    response.errorBody()!!.string()
                ).toString()
            )
            var nextKey: Int? = data.skip + data.limit
            if (nextKey == params.key) {
                nextKey = null
            }

            LoadResult.Page(
                data = data.products?.map { it.mapToDomain() }.orEmpty(),
                prevKey = null,
                nextKey
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}