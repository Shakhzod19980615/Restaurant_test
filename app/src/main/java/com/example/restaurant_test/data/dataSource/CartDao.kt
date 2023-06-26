package com.example.restaurant_test.data.dataSource

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartDao {

    @Query("SELECT * FROM cart_table")
     fun getCartList(): LiveData<List<CartEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cartEntity: CartEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entites: List<CartEntity>)

    @Query("SELECT * FROM cart_table WHERE id=:id")
    suspend fun getCartItemById(id : Int): CartEntity

    @Query("DELETE FROM cart_table WHERE id = :id")
    fun delete(id: Int)


    @Query("DELETE FROM cart_table")
    fun deleteAll()
}