package com.example.naturama.database

import androidx.room.Entity

//таблица с данными

@Entity(tableName = "stats_user")
data class Stats_Room(
    val count_waste: Int,
    val count_places: Int,
    val rating: Int,
)