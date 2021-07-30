package com.example.naturama.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.naturama.R
import com.example.naturama.database.StatsViewModel
import com.example.naturama.database.Stats_Room


class Places : Fragment() {

    private lateinit var mStatsViewModel: StatsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_places, container, false)


        val button: Button? = view.findViewById(R.id.verifyRoom)
        button?.setOnClickListener {
            try {
                insertDataToDatabase()
            } catch (ex: Exception) {
                Toast.makeText(requireContext(), "error: " + ex.message, Toast.LENGTH_LONG)
                    .show()
            }

        }

        return view
    }

    private fun insertDataToDatabase() {

        try {
            mStatsViewModel = ViewModelProvider(this).get(StatsViewModel::class.java)
            val statsRoom = Stats_Room(20, 10, 10)
            mStatsViewModel.addStats(statsRoom)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_places_to_stats)

        } catch (exception: Exception) {
            Toast.makeText(requireContext(), "error: " + exception.message, Toast.LENGTH_LONG)
                .show()
        }

        /*
        countCollected?.text = statsRoom.count_waste.toString()
        rating?.text = statsRoom.rating.toString()
        countVisitedPlaces?.text = statsRoom.count_places.toString()
        countSavedTrees?.text = (statsRoom.count_waste + 10).toString()

         */

    }
}