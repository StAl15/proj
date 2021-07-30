package com.example.naturama.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//передаёт данные в ui и их изменения. Иначе говоря просто связь между Repository и UI
class StatsViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Stats_Room>>
    private val repository: StatsRepository

    init {
        //val statsDao = StatsDatabase.getDatabase(application).statsDao()
        var db: StatsDatabase? = App().database
        var statsDao: StatsDao = db!!.statsDao
        repository = StatsRepository(statsDao)
        readAllData = repository.readAllData
    }

    fun addStats(statsRoom: Stats_Room) {
        //в фоновом потоке
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStats(statsRoom)
        }
    }
}