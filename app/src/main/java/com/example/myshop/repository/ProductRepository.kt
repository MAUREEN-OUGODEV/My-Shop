package com.example.myshop.repository



import com.example.adalabapis.api.APIClient
import com.example.adalabapis.api.APIInterface
import com.example.adalabapis.models.ProductResponse

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProductRepository {
    val apiClient =APIClient.buildClient(APIInterface::class.java)

    suspend fun getProducts():Response<ProductResponse>{
        return  withContext(Dispatchers.IO){
            apiClient.getProducts()
        }
    }
}