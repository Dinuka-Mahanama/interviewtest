package com.example.myapplication.Interface

interface CommonResponseListener {
    fun onSuccessResponse(result: String, from: String, code: Int)
    fun onError(msg: String, fromUrl: String)
}