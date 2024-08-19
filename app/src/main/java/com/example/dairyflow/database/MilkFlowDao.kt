package com.example.dairyflow.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface CollectorDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(collector: CollectorModel)

    @Delete
    suspend fun delete(collector: CollectorModel)

    @Query("SELECT * FROM collector_table ORDER BY id ASC")
    fun getAllCollectors(): LiveData<List<CollectorModel>>

    @Update
    suspend fun update(collector: CollectorModel)

    @Query("SELECT * FROM collector_table WHERE id = :id")
    fun getCollectorById(id:Long):LiveData<CollectorModel>
}

@Dao
interface SupplierDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(supplier:SupplierModel)

    @Delete
    suspend fun delete(supplier:SupplierModel)

    @Query("SELECT * FROM supplier_table ORDER BY id ASC")
    fun getAllSuppliers(): LiveData<List<SupplierModel>>

    @Update
    suspend fun update(supplier:SupplierModel)

    @Query("SELECT * FROM supplier_table WHERE id = :id")
    fun getSupplierById(id:Long):LiveData<SupplierModel>
}