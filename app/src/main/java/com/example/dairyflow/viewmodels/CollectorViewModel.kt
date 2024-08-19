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

    private val collectorDao = MilkFlowDatabase.getDatabase(application).collectorDao()
    private val repository = CollectorRepository(collectorDao)

    val allCollectors: LiveData<List<CollectorModel>> = repository.allCollectors

    private val _totalCollectorsAmount = MutableLiveData<String>()
    val totalCollectorAmount: LiveData<String> get() = _totalCollectorsAmount

    fun addCollector(collector: CollectorModel) = viewModelScope.launch {
        repository.insertCollector(collector)
    }

    fun removeCollector(collector: CollectorModel) = viewModelScope.launch {
        repository.deleteCollector(collector)
    }

    fun updateCollector(collector: CollectorModel) = viewModelScope.launch {
        repository.updateCollector(collector)
    }

    fun calculateTotalSum() {
        allCollectors.value?.let { collectors ->
            _totalCollectorsAmount.value = collectors.sumOf { it.collectorRate * it.collectorQuantity }.toString()
        }
    }
}
