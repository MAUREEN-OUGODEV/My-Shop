package com.example.adalabapis.api

import com.example.adalabapis.models.ProductResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIInterface {
    @GET("/products")
    suspend fun getProducts():Response<ProductResponse>
}