package com.example.naturama.fragments

import android.app.Application
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.naturama.R
import com.example.naturama.database.MyApplication
import com.example.naturama.database.StatsViewModel
import com.example.naturama.database.Stats_Room


class Stats : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_stats, container, false)
        var person_button: ImageView = view.findViewById(R.id.acc)
        person_button.setOnClickListener {
            Toast.makeText(context?.applicationContext, "Person Statistic", Toast.LENGTH_SHORT)
                .show()
            //insertDataToDatabase()
        }


        return view
    }

    /* выдаёт NullPointerException . Почему-то не может получить application. Создал для этого отдельный класс MyApplication. В манифесте 

    private fun insertDataToDatabase() {

        var countCollected: EditText? = null
        var rating: EditText? = null
        var countSavedTrees: EditText? = null
        var countVisitedPlaces: EditText? = null

        countCollected = view?.findViewById(R.id.count_collected)
        rating = view?.findViewById(R.id.user_rating)
        countSavedTrees = view?.findViewById(R.id.count_saved_trees)
        countVisitedPlaces = view?.findViewById(R.id.count_visited_places)


        if (inputCheck(countCollected!!.text, rating!!.text, countVisitedPlaces!!.text)){
            val stats = Stats_Room(Integer.parseInt(countCollected.text.toString()), Integer.parseInt(countVisitedPlaces.text.toString()), Integer.parseInt(rating.text.toString()))
            val mStatsViewModel: StatsViewModel = StatsViewModel(MyApplication().getApplication())
            try  {
                mStatsViewModel.addStats(stats)
                Toast.makeText(context?.applicationContext, "Successfully added!", Toast.LENGTH_SHORT).show()
            } catch (exception: Exception){
                Toast.makeText(context?.applicationContext, "App context cannot be null", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(requireContext(), "Fill all", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(
        countCollected: Editable,
        rating: Editable,
        countVisitedPlaces: Editable,
    ): Boolean {
        return !(countCollected.isEmpty() && rating.isEmpty() && countVisitedPlaces.isEmpty())
    }

     */


}