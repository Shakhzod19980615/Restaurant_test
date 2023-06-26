package com.example.restaurant_test.di.response.menuResponse

import kotlinx.serialization.SerialName
@kotlinx.serialization.Serializable
data class MenuListResponse(
    @SerialName("dishes")
    val dishes:List<MenuItemResponse>
)
