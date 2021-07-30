package com.example.naturama.database

import androidx.lifecycle.LiveData

//даёт доступ к данным из разных источников
class StatsRepository(private val statsDao: StatsDao) {

    val readAllData: LiveData<List<Stats_Room>> = statsDao.readAllData()

    suspend fun addStats(statsRoom: Stats_Room){
        statsDao.addInfoStats(statsRoom)
    }
}