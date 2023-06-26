package com.example.restaurant_test.data.dataSource

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject

@Entity(tableName = "cart_table")
class CartEntity @Inject constructor(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name = "itemName")
    var itemName: String,
    @ColumnInfo(name="itemPrice")
    var itemPrice: Int,
    @ColumnInfo(name = "itemCount")
    var itemCount: Int,
    @ColumnInfo(name = "itemWeight")
    var itemWeight: Int,
    @ColumnInfo(name = "description")
    var itemDescription: String,
    @ColumnInfo(name = "itemImage")
    var itemImage: String,
    @ColumnInfo(name = "tags")
    var itemTags: String
)