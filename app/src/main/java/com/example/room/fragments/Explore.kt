package com.example.room.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.room.R
import com.example.room.data.StatsRoom
import com.example.room.viewmodel.StatsViewModel


class Explore : Fragment() {

    private lateinit var mStatsViewModel: StatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        val verifyRoom: Button = view.findViewById(R.id.verifyRoom)
        mStatsViewModel = ViewModelProvider(this).get(StatsViewModel::class.java)
        verifyRoom.setOnClickListener{
            try {
                insertDataToDatabase()
            }catch (e: Exception){
                Toast.makeText(requireContext(), "Error: "+e.message, Toast.LENGTH_SHORT).show()
            }

        }


        return view
    }

    private fun insertDataToDatabase() {

        //create user object
        val stats = StatsRoom(
            1,
            10,
            10 ,
            12)

        //add data to db
        mStatsViewModel.addStats(stats)
        Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()
        //nav to stats
        findNavController().navigate(R.id.action_explore_to_stats)
    }
    
    private fun updateItem(){
        //create stats object
        val updateStats = StatsRoom(
            1,
            20,
            20,
            22
        )
        //update stats
        mStatsViewModel.updateStats(updateStats)
        Toast.makeText(requireContext(), "Updated Successfully", Toast.LENGTH_SHORT).show()
        //nav to stats
        findNavController().navigate(R.id.action_explore_to_stats)
    }


    private fun deleteAllStats(){
        mStatsViewModel.deleteAllStats() //удалить всё
    }

}
