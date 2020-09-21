package com.saranomy.demoroom

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Song::class, SongFts::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao
}