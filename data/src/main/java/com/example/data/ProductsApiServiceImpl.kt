package com.example.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import retrofit2.Response
import javax.inject.Inject

class ProductsApiServiceImpl @Inject constructor(
    private val context: Context
) : ProductsApiService {

    override suspend fun loadProducts(page: Int): Response<ProductPagingResponse<ProductDto>> {
        delay(2000)
        return when (page) {
            1 -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage1.json")))
            }
            2 -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage2.json")))
            }
            3 -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage3.json")))
            }
            else -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage4.json")))
            }
        }
    }

    internal inline fun <reified T> fromJson(file: String): T {
        return Gson().fromJson(file, object : TypeToken<T>() {}.type)
    }

    /**
     * Get Json from assets package
     *
     * @return Json file from assets
     */
    internal fun Context.jsonFromAssets(fileName: String): String {
        return this.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}