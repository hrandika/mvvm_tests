package com.example.mvvm_tests.data.main.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_tests.data.main.model.DatabaseVideo

@Dao
interface MainDao {
    @Query("select * from databasevideo")
    fun getVideos(): LiveData<List<DatabaseVideo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( videos: List<DatabaseVideo>)
}
