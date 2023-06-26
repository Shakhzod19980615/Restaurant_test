package com.example.restaurant_test.domain.model.menuModel

class MenuItemModel(
    val id:Int,
    val dishName:String,
    val price:Int,
    val weight:Int,
    var itemCount:Int,
    val description:String,
    val dishImage:String,
    val tegs:List<String>
)