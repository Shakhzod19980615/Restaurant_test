package com.example.restaurant_test.data.repositoryImpl

import com.example.restaurant_test.data.ApiService
import com.example.restaurant_test.data.mapper.mapToCategoryListModel
import com.example.restaurant_test.data.mapper.mapToMenuListModel
import com.example.restaurant_test.domain.repository.CategoryRepository
import com.example.restaurant_test.domain.model.categoryModel.CategoryListModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel
import javax.inject.Inject

class CategroyRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
): CategoryRepository {
    override suspend fun getCategoryList(): CategoryListModel {
        return try {
            val result  =apiService.getCategoryList()
            result.mapToCategoryListModel()
        }catch (e:Exception){
            return  CategoryListModel(emptyList())
        }
    }

    override suspend fun getMenuList(): MenuListModel {
        return try {
            val result = apiService.getMenuList()
            result.mapToMenuListModel()
        }catch (e:java.lang.Exception){
            return MenuListModel(emptyList())
        }
    }

    /*override suspend fun getSaladList(): List<MenuListModel> {
        return try listOf({
            val result = apiService.getMenuList()
            result.mapToMenuListModel()
        }) catch (e:java.lang.Exception){
            return MenuListModel(emptyList())
        }
    }*/
}