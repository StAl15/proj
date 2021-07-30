package com.example.naturama.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Сама БД

@Database(entities = [Stats_Room::class], version = 1, exportSchema = false)
abstract class StatsDatabase : RoomDatabase() {

    abstract var statsDao: StatsDao
    

}

class App : Application() {
    var instance: App? = null
    var database: StatsDatabase? = null

    override fun onCreate() {
        super.onCreate()
        synchronized(this) {
            instance = this
            if (database == null || instance == null) {
                database = Room.databaseBuilder(this,
                    StatsDatabase::class.java,
                    "stats_database"
                ).build()
            }
        }
        fun getInstance(): App {
            return instance!!
        }

        fun getDatabase(): StatsDatabase {
            return database!!
        }

    }
}