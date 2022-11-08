package com.example.mvvm_tests.ui.main

import androidx.room.*
import com.example.mvvm_tests.data.main.local.MainDao
import com.example.mvvm_tests.di.ApplicationScope
import com.example.mvvm_tests.data.main.model.DatabaseVideo
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [DatabaseVideo::class], version = 1)
abstract class VideosDatabase: RoomDatabase() {
    abstract val mainDao:MainDao

    class Callback @Inject constructor(
        private val database: Provider<VideosDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()
}