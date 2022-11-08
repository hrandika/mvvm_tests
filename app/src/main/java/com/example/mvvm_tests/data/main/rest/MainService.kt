package com.example.mvvm_tests.data.main.rest

import com.example.mvvm_tests.data.main.model.NetworkVideoContainer
import retrofit2.Response
import retrofit2.http.GET

interface MainService {
    @GET("devbytes")
    suspend fun getPlaylist(): Response<NetworkVideoContainer>
}