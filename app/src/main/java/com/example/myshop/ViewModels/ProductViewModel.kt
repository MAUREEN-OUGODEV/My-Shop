package com.example.myshop.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.myshop.models.Products
import com.example.myshop.repository.ProductRepository


import kotlinx.coroutines.launch


class ProductsViewModel:ViewModel() {
    val productsRepo=ProductRepository()
    val productsLiveData =MutableLiveData<List<Products>>()
    val errorLiveData =MutableLiveData<String>()

    fun fetchProduct(){
        viewModelScope.launch {
            val response =productsRepo.getProducts()
            if(response.isSuccessful){
                productsLiveData.postValue(response.body()?.products)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }

        }
    }
}