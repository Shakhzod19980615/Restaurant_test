package com.example.restaurant_test.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurant_test.domain.interactor.category.CategoryInteractor
import com.example.restaurant_test.domain.model.categoryModel.CategoryListModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val categoryInteractor: CategoryInteractor
): ViewModel() {

    private val categoryListLiveData_ : MutableLiveData<CategoryListModel>
            = MutableLiveData<CategoryListModel>()
    val categoryListLiveData : LiveData<CategoryListModel> = categoryListLiveData_

    private val menuListLiveData_:MutableLiveData<MenuListModel>
            = MutableLiveData<MenuListModel>()
    val menuListLiveData:LiveData<MenuListModel> = menuListLiveData_

    fun getCategoryList(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = categoryInteractor.getCategoryList()
                categoryListLiveData_.postValue(result)
            }
        }
    }

    fun getMenuList(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result =categoryInteractor.getMenuList()
                menuListLiveData_.postValue(result)
            }
        }
    }
}