package com.example.dairyflow.database
import com.example.dairyflow.BR

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "collector_table")
data class CollectorModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var collectorName: String,
    var collectorRate: Int,
    var collectorQuantity: Int
)
//    : BaseObservable() {
//
//    @get:Bindable
//    var inputQuantity: String = collectorQuantity.toString()
//        set(value) {
//            field = value
//            notifyPropertyChanged(BR.inputQuantity)
//            collectorQuantity = value.toIntOrNull() ?: 0
//        }
//}

@Entity(tableName = "supplier_table")
data class SupplierModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var supplierName: String,
    var supplierRate: Int,
    var supplierQuantity: Int
)

@Entity(tableName = "expense_table")
data class ExpenseModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var itemName: String,
    var itemPrice: Int
)


