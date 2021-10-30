package com.example.myapplication.Interface

import com.example.myapplication.Model.Product
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("products")
    fun getProductList(): Call<MutableList<Product>>
}