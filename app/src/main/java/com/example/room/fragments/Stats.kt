package com.example.room.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.adapters.StatsAdapter
import com.example.room.viewmodel.StatsViewModel


class Stats : Fragment() {

    private lateinit var mStatsViewModel: StatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_stats, container, false)

        //RecyclerView
        val adapter = StatsAdapter()
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //StatsViewModel
        mStatsViewModel = ViewModelProvider(this).get(StatsViewModel::class.java)
        mStatsViewModel.readAllData.observe(viewLifecycleOwner, Observer { stats ->
            adapter.setData(stats)
        })

        return view
    }



}