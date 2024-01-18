package com.example.immagic.homepage.Play

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PlayQuoteViewModel(
    private val quoteRepository: PlayQuoteRepository,
    private val cardSetId: Int
) : ViewModel() {

    private val _quoteList = MutableLiveData<List<QuoteModel>>()
    val quoteList: LiveData<List<QuoteModel>> get() = _quoteList

    init {
        viewModelScope.launch {
            val quotes = quoteRepository.getAllQuotes(cardSetId)
            _quoteList.postValue(quotes)
        }
    }
}

