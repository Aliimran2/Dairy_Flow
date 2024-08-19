package com.example.dairyflow.database

import androidx.lifecycle.LiveData

class SupplierRepository(private val supplierDao: SupplierDao) {

    val allSuppliers: LiveData<List<SupplierModel>> = supplierDao.getAllSuppliers()
    suspend fun insertSupplier(supplierModel: SupplierModel) {
        supplierDao.insert(supplierModel)
    }

    suspend fun deleteSupplier(supplierModel: SupplierModel) {
        supplierDao.insert(supplierModel)
    }

    suspend fun updateSupplier(supplierModel: SupplierModel) {
        supplierDao.update(supplierModel)
    }
}