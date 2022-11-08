package com.example.mvvm_tests.data.main.repository

import com.example.mvvm_tests.data.main.local.MainDao
import com.example.mvvm_tests.data.main.model.asDomainModel
import com.example.mvvm_tests.data.main.performGetOperation
import com.example.mvvm_tests.data.main.rest.MainRestService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val service:MainRestService,
    private val dao: MainDao
) {
    fun findAll () = performGetOperation(
        databaseQuery = { dao.getVideos() },
        networkCall = { service.findAll() },
        saveCallResult = { dao.insertAll(it.asDomainModel()) }
    )
}