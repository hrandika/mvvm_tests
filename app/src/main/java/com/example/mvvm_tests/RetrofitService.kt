package com.example.mvvm_tests.ui.main

import com.example.mvvm_tests.ui.main.models.NetworkVideoContainer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface DevbyteService {
    @GET("devbytes")
    suspend fun getPlaylist(): NetworkVideoContainer
}