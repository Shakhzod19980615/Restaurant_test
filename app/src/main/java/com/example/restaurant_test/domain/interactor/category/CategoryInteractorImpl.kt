package com.example.restaurant_test.domain.interactor.category

import com.example.restaurant_test.data.mapper.mapToCartEntity
import com.example.restaurant_test.domain.repository.CategoryRepository
import com.example.restaurant_test.domain.model.categoryModel.CategoryListModel
import com.example.restaurant_test.domain.model.menuModel.MenuItemModel
import com.example.restaurant_test.domain.model.menuModel.MenuListModel
import javax.inject.Inject

class CategoryInteractorImpl @Inject constructor(
        private val categoryRepository: CategoryRepository
): CategoryInteractor {
    override suspend fun getCategoryList(): CategoryListModel {
        return categoryRepository.getCategoryList()
    }

    override suspend fun getMenuList(): MenuListModel {
        val allTegs = categoryRepository.getMenuList().menus.flatMap { it.tegs }.toSet()
       val allProducts = categoryRepository.getMenuList().menus
        val products = allTegs.map { teg->
            allProducts.filter { it.tegs.contains(teg) }
        }
        val product = allTegs.map { teg->
            allProducts.groupBy { it.tegs.contains(teg) }
        }
        return categoryRepository.getMenuList()

    }

    /*override suspend fun getSaladList(): MenuListModel {
        val list = categoryRepository.getMenuList().menus
        val saladList = categoryRepository.getMenuList().menus.map { it.tegs }.toSet()
        val salads = saladList.groupBy { it }
        return salads
    }*/
}