package com.example.restaurant_test.data.mapper

import com.example.restaurant_test.di.response.categoryResponse.CategoryItemResponse
import com.example.restaurant_test.di.response.categoryResponse.CategoryListResponse
import com.example.restaurant_test.di.response.menuResponse.MenuItemResponse
import com.example.restaurant_test.di.response.menuResponse.MenuListResponse
import com.example.restaurant_test.domain.model.categoryModel.CategoryItemModel
import com.example.restaurant_test.domain.model.categoryModel.CategoryListModel
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel

fun CategoryListResponse.mapToCategoryListModel(): CategoryListModel {
    return  CategoryListModel(
        categories = categories.map { it.mapToCategoryItemModel() }
    )
}
fun CategoryItemResponse.mapToCategoryItemModel(): CategoryItemModel {
    return  CategoryItemModel(
        id = id,
        name = name,
        image = image
    )
}

fun MenuListResponse.mapToMenuListModel(): MenuListModel{
    return MenuListModel(
        menus = dishes.map { it.mapToMenuItemModel() }
    )
}

fun MenuItemResponse.mapToMenuItemModel(): MenuItemModel {
    return  MenuItemModel(
        id = id,
        dishName = dishName,
        price = price,
        weight = weight,
        description =description,
        dishImage=dishImage,
        tegs = tegs,
        itemCount = 1,
    )
}