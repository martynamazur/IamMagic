package com.example.immagic.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomePageViewModel(private val repository: HomePageRepository): ViewModel() {

    private val _alchemyBottlesTopBar = MutableLiveData<String>()
    val alchemyBottlesTopBar: LiveData<String>
    get() = _alchemyBottlesTopBar

    private val _energyLvTopBar = MutableLiveData<String>()
    val energyLvTopBar: LiveData<String>
    get() = _energyLvTopBar


    private val _levelTopBar = MutableLiveData<String>()
    val levelTopBar: LiveData<String>
    get() = _levelTopBar

    init {
        _levelTopBar.value = repository.getUserLevel()
        _energyLvTopBar.value = repository.getEnergyLv()
        _alchemyBottlesTopBar.value = repository.getAlchemyBottles()
    }



}