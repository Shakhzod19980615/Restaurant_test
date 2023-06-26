package com.example.restaurant_test.domain.repository

import com.example.restaurant_test.domain.model.categoryModel.CategoryListModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel

interface CategoryRepository {
    suspend fun getCategoryList(): CategoryListModel
    suspend fun getMenuList():MenuListModel
    //suspend fun getSaladList():List<MenuListModel>
}