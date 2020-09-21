package com.saranomy.demoroom

import androidx.room.*

@Entity
data class Song(
    val url: String,
    val duration: Int,
    @Embedded
    val songLabel: SongLabel
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0 // use var because it will be assigned later
}