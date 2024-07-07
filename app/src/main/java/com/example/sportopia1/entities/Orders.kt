package com.example.sportopia1.entities
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "OrdersDetails")
data class Orders(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val ordersName: String,
    val ordersDetails: String,
    val ordersNumber: String,
    val address: String,
)
