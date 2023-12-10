package com.example.immagic.nawigation.myprofile.myaddedcards.notempty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.immagic.createquote.CreateNewQuoteModel

class MyAddedCardsViewModel : ViewModel() {

    private val _quotesLiveData: MutableLiveData<List<CreateNewQuoteModel>> = MutableLiveData()
    val quotesLiveData: LiveData<List<CreateNewQuoteModel>> = _quotesLiveData

    fun updateQuotesList(updatedQuotesList: List<CreateNewQuoteModel>) {
        _quotesLiveData.postValue(updatedQuotesList)
    }

}
