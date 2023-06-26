package com.example.restaurant_test.data.repositoryImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.restaurant_test.data.dataSource.CartDao
import com.example.restaurant_test.data.mapper.mapToCartEntity
import com.example.restaurant_test.data.mapper.mapToMenuItemModel
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel
import com.example.restaurant_test.domain.repository.CartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao
):CartRepository {
    override suspend fun insertCartItem(item: MenuItemModel) {
        return cartDao.insert(cartEntity = item.mapToCartEntity())
    }

    override  fun getCartItemList(): LiveData<List<MenuItemModel>> {
        return cartDao.getCartList().map { it.map { it.mapToMenuItemModel() } }
    }

    override suspend fun deleteCartItem(id: Int) {
        return cartDao.delete(id = id)
    }

}