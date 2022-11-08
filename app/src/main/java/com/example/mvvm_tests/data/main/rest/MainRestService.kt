package com.example.mvvm_tests.data.main.rest

import com.example.mvvm_tests.data.BaseDataSource
import com.example.mvvm_tests.data.main.model.NetworkVideoContainer
import retrofit2.http.GET
import javax.inject.Inject

class MainRestService @Inject constructor(
    private  val mainService: MainService
):BaseDataSource(){
    suspend fun findAll() = getResult { mainService.getPlaylist() }
}