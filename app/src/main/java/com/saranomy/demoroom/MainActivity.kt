package com.saranomy.demoroom

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "song-database"
            ).build()

            if (db.songDao().getAll().isEmpty()) {
                val newSong = Song(
                    "1d12c",
                    11,
                    SongLabel("Game", "Love", "Elon")
                )
                db.songDao().insertAll(newSong)
            }
            val resultStr = db.songDao().searchSongs("Game").toString()
            findViewById<TextView>(R.id.result).text = resultStr
            Log.e("TAG", "onCreate: $resultStr")
        }
    }
}