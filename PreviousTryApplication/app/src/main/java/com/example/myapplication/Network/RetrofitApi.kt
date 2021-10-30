package com.example.myapplication.Network

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {
    @GET(WebUrls.GET_PRODUCTS)
    fun getProducts(): Call<JsonElement>
}