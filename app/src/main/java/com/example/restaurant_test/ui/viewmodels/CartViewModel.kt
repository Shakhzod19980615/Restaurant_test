package com.example.restaurant_test.ui.viewmodels

import androidx.lifecycle.*
import com.example.restaurant_test.domain.interactor.cart.CartInteractor
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val cartInteractor: CartInteractor
) :ViewModel(){

    private val insertCartItemLiveData_ : MutableLiveData<MenuItemModel>
            = MutableLiveData<MenuItemModel>()
    val insertFavouriteItemLiveData : LiveData<MenuItemModel> = insertCartItemLiveData_


    private val deleteCartItemListLiveData_ : MutableLiveData<MenuItemModel>
        = MutableLiveData<MenuItemModel>()
    val deleteCartItemListLiveData : LiveData<MenuItemModel> = deleteCartItemListLiveData_

    val itemsLiveData:LiveData<List<MenuItemModel>> = cartInteractor.getCartItemList()

    fun insertCartItem(item:MenuItemModel){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = cartInteractor.insertCartItem(item = item).let { item }
                insertCartItemLiveData_.postValue(result)
            }
        }
    }


    fun deleteCartItem(item:MenuItemModel){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = cartInteractor.deleteCartItem(id = item.id).let { item }
                deleteCartItemListLiveData_.postValue(result)
            }
        }
    }
}