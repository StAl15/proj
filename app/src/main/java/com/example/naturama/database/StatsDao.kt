package com.example.naturama.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

//методы для работы с данными таблицы

@Dao
interface StatsDao {

    //create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addInfoStats(statsRoom: Stats_Room)

    //read
    @Query("SELECT * FROM stats_user")
    fun readAllData(): LiveData<List<Stats_Room>>

}