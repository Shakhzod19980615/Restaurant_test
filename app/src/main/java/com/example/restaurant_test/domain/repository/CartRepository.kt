package com.example.restaurant_test.domain.repository

import androidx.lifecycle.LiveData
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel

interface CartRepository {
    suspend fun insertCartItem(item: MenuItemModel)
     fun getCartItemList(): LiveData<List<MenuItemModel>>
    suspend fun deleteCartItem(id:Int)
}