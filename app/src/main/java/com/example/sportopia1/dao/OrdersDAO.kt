package com.example.sportopia1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.sportopia1.entities.Orders

@Dao
interface OrdersDAO {

    @Insert
    suspend fun insertOrders(orders: Orders)

    @Update
    suspend fun updateOrders(orders: Orders)

    @Delete
    suspend fun deleteOrders(orders: Orders)

    @Query("SELECT * FROM OrdersDetails")
    fun getOrders(): LiveData<List<Orders>>

}
