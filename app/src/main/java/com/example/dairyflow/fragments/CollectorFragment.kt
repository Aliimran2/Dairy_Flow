package com.example.dairyflow.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dairyflow.CollectorAdapter
import com.example.dairyflow.DialogUtil
import com.example.dairyflow.R
import com.example.dairyflow.database.CollectorModel
import com.example.dairyflow.databinding.FragmentCollectorBinding
import com.example.dairyflow.viewmodels.CollectorViewModel


class CollectorFragment : Fragment() {

    private lateinit var binding: FragmentCollectorBinding
    private lateinit var collectorViewModel: CollectorViewModel
    private lateinit var collectorAdapter: CollectorAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_collector, container, false)
        collectorViewModel = ViewModelProvider(this)[CollectorViewModel::class.java]

        binding.collectorViewModel = collectorViewModel
        binding.lifecycleOwner = this

        collectorAdapter = CollectorAdapter(listOf(), collectorViewModel)
        binding.collectorRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.collectorRecycleView.adapter = collectorAdapter

        collectorViewModel.allCollectors.observe(viewLifecycleOwner) { collectors ->
            collectorAdapter.updateCollector(collectors)
            collectorViewModel.calculateTotalSum()
        }




        binding.floatingActionButton.setOnClickListener {
            DialogUtil.addPerson(requireContext()){newCollector ->
                collectorViewModel.addCollector(newCollector)

            }


        }


        return binding.root
    }

}