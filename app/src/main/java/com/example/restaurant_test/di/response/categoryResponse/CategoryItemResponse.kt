package com.example.restaurant_test.di.response.categoryResponse

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CategoryItemResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name : String,
    @SerialName("image_url")
    val image : String
)