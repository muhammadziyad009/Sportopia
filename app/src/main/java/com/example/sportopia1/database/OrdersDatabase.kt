package com.example.sportopia1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sportopia1.dao.OrdersDAO
import com.example.sportopia1.entities.Orders
import com.example.sportopia1.converters.OrdersTypeConverters // Make sure you have a correct TypeConverters class

@Database(
    entities = [Orders::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(OrdersTypeConverters::class)
abstract class OrdersDatabase : RoomDatabase() {
    abstract fun ordersDAO(): OrdersDAO

    companion object {
        @Volatile
        private var INSTANCE: OrdersDatabase? = null

        fun getDatabase(context: Context): OrdersDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OrdersDatabase::class.java,
                    "orders_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
