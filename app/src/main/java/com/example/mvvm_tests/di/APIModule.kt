package com.example.mvvm_tests.di

import com.example.mvvm_tests.data.main.rest.MainRestService
import com.example.mvvm_tests.data.main.rest.MainService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APIModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDevbyteService(retrofit:Retrofit): MainService {
        return retrofit.create(MainService::class.java)
    }

}