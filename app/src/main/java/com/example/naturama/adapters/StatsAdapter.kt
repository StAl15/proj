package com.example.naturama.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.naturama.R
import com.example.naturama.database.Stats_Room

class StatsAdapter : RecyclerView.Adapter<StatsAdapter.MyViewHolder>() {

    var statsList = emptyList<Stats_Room>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val countWaste: TextView = holder.itemView.findViewById(R.id.txt_collected)
        val countVisitedPlaces: TextView = holder.itemView.findViewById(R.id.txt_visited_places)
        val rank: TextView = holder.itemView.findViewById(R.id.txt_rank)
        val savedTrees: TextView = holder.itemView.findViewById(R.id.txt_saved_trees)

        val currentItem = statsList[position]

        countWaste.text = currentItem.count_waste.toString()
        countVisitedPlaces.text = currentItem.count_places.toString()
        rank.text = currentItem.rating.toString()
        savedTrees.text = (currentItem.count_waste+10).toString()

    }

    override fun getItemCount(): Int {
        return statsList.size
    }

    fun setData(stats: List<Stats_Room>){
        this.statsList = stats
        notifyDataSetChanged()
    }
}