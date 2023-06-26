package com.example.restaurant_test.domain.interactor.cart

import androidx.lifecycle.LiveData
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel
import com.example.restaurant_test.domain.repository.CartRepository
import javax.inject.Inject

class CartInteractorImpl @Inject constructor(
    private val cartRepository: CartRepository
):CartInteractor {
    override suspend fun insertCartItem(item: MenuItemModel) {
        return cartRepository.insertCartItem(item = item)
    }

    override  fun getCartItemList(): LiveData<List<MenuItemModel>> {
        return cartRepository.getCartItemList()
    }

    override suspend fun deleteCartItem(id: Int) {
        return cartRepository.deleteCartItem(id = id)
    }
}