package com.example.restaurant_test.di.response.categoryResponse

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CategoryListResponse(
    @SerialName("сategories")
    val categories : List<CategoryItemResponse>
)