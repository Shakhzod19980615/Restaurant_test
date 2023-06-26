package com.example.restaurant_test.domain.interactor.cart

import androidx.lifecycle.LiveData
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel

interface CartInteractor {
    suspend fun insertCartItem(item: MenuItemModel)
     fun getCartItemList(): LiveData<List<MenuItemModel>>
    suspend fun deleteCartItem(id:Int)
}