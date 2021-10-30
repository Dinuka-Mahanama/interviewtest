package com.example.myapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductModel(
//    @SerializedName("id")
//    @Expose
//    var id: String? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("price")
    @Expose
    var price: String? = null,

    @SerializedName("rating")
    @Expose
    var rating: Double? = null,

    @SerializedName("description")
    @Expose
    var description: List<String>? = null,

    @SerializedName("image")
    @Expose
    var image: String? = null
)