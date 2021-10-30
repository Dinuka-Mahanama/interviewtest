package com.example.myapplication.Common

import com.example.myapplication.Interface.RetrofitService
import com.example.myapplication.Retrofit.RetrofitClient


object Common {
    private val BASE_URL = "https://59b8726e92ccc3eb44b0c193eeef96f6.m.pipedream.net/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}