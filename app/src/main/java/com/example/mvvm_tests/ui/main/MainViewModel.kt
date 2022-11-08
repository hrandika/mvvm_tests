package com.example.mvvm_tests.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_tests.data.main.model.DevByteVideo
import androidx.lifecycle.viewModelScope
import com.example.mvvm_tests.data.main.model.asDomainModel
import com.example.mvvm_tests.data.main.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val mainRepository: MainRepository
) : ViewModel() {

    val videos = mainRepository.findAll()

    private var _score = MutableLiveData<String>().apply {
        value = "0"
    }
    var score : LiveData<String> = _score

    private val _playlist = MutableLiveData<List<DevByteVideo>>()
    val playlist: LiveData<List<DevByteVideo>>
        get() = _playlist

    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    init {
        getDataFromRepository()
    }

    private fun getDataFromRepository() = viewModelScope.launch {
//        mainRepository.findAll().
//        try {
//            val playlist = devbyteService.getPlaylist()
//            _playlist.postValue(playlist.asDomainModel())
//            _eventNetworkError.value = false
//            _isNetworkErrorShown.value = false
//        } catch (networkError: IOException) {
//            _eventNetworkError.value = true
//        }
    }

    fun increase(){
        var v = _score.value?.toInt()
        _score.value = "${v?.plus(1)}"
        Log.d("MainViewModel ","${_score.value}")
    }
}