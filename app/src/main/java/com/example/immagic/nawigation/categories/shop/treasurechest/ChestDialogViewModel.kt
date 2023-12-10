package com.example.immagic.nawigation.categories.shop.treasurechest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChestDialogViewModel: ViewModel() {

    private val _chestQuantity = MutableLiveData<Int>()
    val chestQuantity: LiveData<Int> get() = _chestQuantity

    fun updateChestQuantity(newQuantity: Int){
        _chestQuantity.value = newQuantity
    }

}