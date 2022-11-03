package com.example.mvvm_tests.ui.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvm_tests.di.ApplicationScope
import com.example.mvvm_tests.ui.main.models.DatabaseVideo
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Dao
interface VideoDao {
    @Query("select * from databasevideo")
    fun getVideos(): LiveData<List<DatabaseVideo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( videos: List<DatabaseVideo>)
}

@Database(entities = [DatabaseVideo::class], version = 1)
abstract class VideosDatabase: RoomDatabase() {
    abstract val videoDao: VideoDao

    class Callback @Inject constructor(
        private val database: Provider<VideosDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()
}