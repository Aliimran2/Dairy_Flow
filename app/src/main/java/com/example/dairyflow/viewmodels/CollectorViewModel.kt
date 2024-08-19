package com.example.dairyflow.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dairyflow.database.CollectorModel
import com.example.dairyflow.database.MilkFlowDatabase
import com.example.dairyflow.database.CollectorRepository
import kotlinx.coroutines.launch

class CollectorViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CollectorRepository
    val allCollectors: LiveData<List<CollectorModel>>

    private val  _totalCollectorsAmount = MutableLiveData<Int>()
    val totalCollectorAmount get() = _totalCollectorsAmount




    init {


        val collectorDao = MilkFlowDatabase.getDatabase(application).collectorDao()
        repository = CollectorRepository(collectorDao)
        allCollectors = repository.allCollectors
    }

    fun addCollector(collector: CollectorModel) = viewModelScope.launch {
        repository.insertCollector(collector)
    }

    fun removeCollector(collector: CollectorModel) = viewModelScope.launch {
        repository.deleteCollector(collector)
    }

    fun onDeleteClick(collector: CollectorModel) {
        removeCollector(collector)
    }

    fun updateCollector(collector: CollectorModel) = viewModelScope.launch {
        repository.updateCollector(collector)
    }

    fun onEditClick(collector: CollectorModel) {
        updateCollector(collector)
    }

    fun calculateTotalSum (collectors: List<CollectorModel>){
        _totalCollectorsAmount.value =collectors.sumOf { it.collectorRate * it.collectorQuantity }
    }




}