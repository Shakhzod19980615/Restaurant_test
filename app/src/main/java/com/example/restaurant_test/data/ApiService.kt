package com.example.restaurant_test.data

import com.example.restaurant_test.di.response.categoryResponse.CategoryListResponse
import com.example.restaurant_test.di.response.menuResponse.MenuListResponse
import retrofit2.http.GET

interface ApiService {

    @GET("058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategoryList(): CategoryListResponse

    @GET("aba7ecaa-0a70-453b-b62d-0e326c859b3b")
    suspend fun getMenuList(): MenuListResponse
}