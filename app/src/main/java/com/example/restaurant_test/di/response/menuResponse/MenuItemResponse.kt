package com.example.restaurant_test.di.response.menuResponse

import kotlinx.serialization.SerialName
@kotlinx.serialization.Serializable
data class MenuItemResponse(
    @SerialName("id")
    val id:Int,
    @SerialName("name")
    val dishName:String,
    @SerialName("price")
    val price:Int,
    @SerialName("weight")
    val weight:Int,
    @SerialName("description")
    val description: String,
    @SerialName("image_url")
    val dishImage:String,
    @SerialName("tegs")
    val tegs : List<String>
)
