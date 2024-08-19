package com.example.dairyflow.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CollectorModel::class, SupplierModel::class, ExpenseModel::class],
    version = 1,
    exportSchema = false
)
abstract class MilkFlowDatabase : RoomDatabase() {

    abstract fun collectorDao(): CollectorDao
    abstract fun supplierDao(): SupplierDao

    companion object {
        @Volatile
        private var INSTANCE: MilkFlowDatabase? = null

        fun getDatabase(context: Context): MilkFlowDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MilkFlowDatabase::class.java,
                    "milkFlow_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}