package com.example.dairyflow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dairyflow.database.CollectorModel
import com.example.dairyflow.databinding.ItemViewBinding
import com.example.dairyflow.viewmodels.CollectorViewModel

class CollectorAdapter(
    private var collectorList: List<CollectorModel>,
    private val collectorViewModel: CollectorViewModel
) :
    RecyclerView.Adapter<CollectorAdapter.CollectorVH>() {
    inner class CollectorVH(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(collectorModel: CollectorModel) {
            binding.collectorModel = collectorModel
            binding.executePendingBindings()
            binding.deleteIcon.setOnClickListener {
                collectorViewModel.removeCollector(collectorModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectorVH {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CollectorVH(binding)
    }

    override fun getItemCount(): Int {
        return collectorList.size
    }

    override fun onBindViewHolder(holder: CollectorVH, position: Int) {
        holder.bind(collectorList[position])
    }

    fun updateCollector(newList: List<CollectorModel>) {
        this.collectorList = newList
        notifyDataSetChanged()
    }

}