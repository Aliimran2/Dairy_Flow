package com.example.dairyflow

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.dairyflow.database.CollectorModel

object DialogUtil {

    fun addPerson(context:Context, onAdd: (CollectorModel) -> Unit){
        val view = LayoutInflater.from(context).inflate(R.layout.person_dialog, null)

        val personName = view.findViewById<TextView>(R.id.et_name)
        val personRate = view.findViewById<TextView>(R.id.et_rate)

        val dialog = AlertDialog.Builder(context)
            .setTitle("Add new person")
            .setView(view)
            .setPositiveButton("Save"){_,_ ->
                val name = personName.text.toString()
                val rate = personRate.text.toString().toIntOrNull() ?: 0

                if (name.isNotEmpty() && rate>0){
                    val collector = CollectorModel(collectorName = name, collectorRate = rate, collectorQuantity = 0)
                    onAdd(collector)
                }
            }
            .setNegativeButton("Cancel", null)
            .create()
        dialog.show()
    }
}