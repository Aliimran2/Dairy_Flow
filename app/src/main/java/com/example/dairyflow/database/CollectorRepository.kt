package com.example.dairyflow.database

import androidx.lifecycle.LiveData

class CollectorRepository(private val collectorDao: CollectorDao) {
    val allCollectors: LiveData<List<CollectorModel>> = collectorDao.getAllCollectors()


    suspend fun insertCollector(collectorModel: CollectorModel) {
        collectorDao.insert(collectorModel)
    }

    suspend fun deleteCollector(collectorModel: CollectorModel) {
        collectorDao.delete(collectorModel)
    }

    suspend fun updateCollector(collectorModel: CollectorModel) {
        collectorDao.update(collectorModel)
    }



}