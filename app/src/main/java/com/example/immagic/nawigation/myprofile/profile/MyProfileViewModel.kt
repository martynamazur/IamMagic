package com.example.immagic.nawigation.myprofile.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch


class MyProfileViewModel(private val repository: MyProfileRepository): ViewModel() {

    private val _helloName = MutableLiveData<String>()
    val helloName: LiveData<String>
    get() = _helloName

    private val _userStatistics = MutableLiveData<List<ProfileStatisticModel>>()
    val userStatistics: LiveData<List<ProfileStatisticModel>>
        get() = _userStatistics



    init {
        viewModelScope.launch {

            _helloName.value = repository.getUsername()
            _userStatistics.value = repository.getUserStatisticInfo()
        }
    }

    fun updateHelloName(newName: String){
        _helloName.value = newName
    }

    suspend fun fetchHelloName() {
        val fetchedName = repository.getUsername()
        _helloName.value = fetchedName
    }



}