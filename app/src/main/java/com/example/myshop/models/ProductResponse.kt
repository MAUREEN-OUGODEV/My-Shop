package com.example.adalabapis.models

import com.example.myshop.models.Products

data class ProductResponse(
    var products:List<Products>,
    var total:Int,
    var skip:Int,
    var limit:Int

)
