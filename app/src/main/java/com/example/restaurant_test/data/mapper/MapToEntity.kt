package com.example.restaurant_test.data.mapper

import com.example.restaurant_test.data.dataSource.CartEntity
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel

fun MenuItemModel.mapToCartEntity():CartEntity{
    return CartEntity(
        id = id,
        itemName = dishName,
        itemPrice = price,
        itemWeight = weight,
        itemDescription = description,
        itemImage = dishImage,
        itemTags = tegs.joinToString("-"),
        itemCount = itemCount
    )
}

fun CartEntity.mapToMenuItemModel():MenuItemModel{
    return MenuItemModel(
        id = id,
        dishName = itemName,
        dishImage = itemImage,
        price = itemPrice,
        weight = itemWeight,
        description = itemDescription,
        tegs = itemTags.split("-"),
        itemCount = itemCount
    )
}