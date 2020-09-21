package com.saranomy.demoroom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SongDao {
    @Query("SELECT * FROM Song")
    fun getAll(): List<Song>

    @Query("SELECT * FROM Song WHERE id IN (:id)")
    fun loadAllByIds(id: IntArray): List<Song>

    @Query(
        """
        SELECT Song.*
        FROM SongFts
        JOIN Song ON (SongFts.rowid = id)
        WHERE SongFts MATCH :query
    """
    )
    // search in all fields in SongFts (fields in SongLabel)
    fun searchSongs(query: String): List<Song>

    @Insert
    fun insertAll(vararg songs: Song)

    @Delete
    fun delete(song: Song)
}