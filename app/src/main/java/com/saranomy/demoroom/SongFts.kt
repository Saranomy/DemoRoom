package com.saranomy.demoroom

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Fts4

@Entity
@Fts4(contentEntity = Song::class)
data class SongFts(@Embedded val label: SongLabel)