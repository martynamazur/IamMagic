package com.example.immagic.nawigation.favourite

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.immagic.nawigation.favourite.FavouriteCardsModel
import com.example.immagic.nawigation.favourite.cardset.FavouriteCardSetModel
import kotlinx.coroutines.launch

class FavouriteViewModel(private val favouriteRepository: FavouriteRepository) : ViewModel() {

    private val _favouriteCardSetList = MutableLiveData<List<FavouriteCardSetModel>>()
    val favouriteCardSetList: LiveData<List<FavouriteCardSetModel>> get() = _favouriteCardSetList

    private val _getTotalNumberOfFavouriteCardSet = MutableLiveData<Int>()
    val getTotalNumberOfFavCardSet: LiveData<Int> get() = _getTotalNumberOfFavouriteCardSet


    private val _favouriteCards = MutableLiveData<List<FavouriteCardsModel>>()
    val favouriteCards: LiveData<List<FavouriteCardsModel>> get() = _favouriteCards

    private val _getTotalNumberOfFavouriteCards = MutableLiveData<Int>()
    val getTotalNumberOfFavouriteCards: LiveData<Int>
        get() = _getTotalNumberOfFavouriteCards

    init {
        viewModelScope.launch {
            _favouriteCards.value = favouriteRepository.getAllFavouriteCards()
            _favouriteCardSetList.value = favouriteRepository.getAllFavouriteCardSet()
            fetchTotalNumberOfFavCards()
            fetchTotalNumberOfFavCardSet()

        }
    }

    private fun fetchTotalNumberOfFavCardSet() {
        viewModelScope.launch {
            try {
                val number = favouriteRepository.getTotalNumberOfFavouriteCardSet()
                    _getTotalNumberOfFavouriteCardSet.postValue(number)
            }catch (e: Exception){
                e.printStackTrace()
                0
            }
        }
    }

    private fun fetchTotalNumberOfFavCards() {
        viewModelScope.launch {
            try {
                val number = favouriteRepository.getTotalNumberOfFavouriteCards()
                _getTotalNumberOfFavouriteCards.postValue(number)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteQuoteFromList(quoteId: Int) {
        viewModelScope.launch {
                favouriteRepository.deleteQuoteFromList(quoteId)
        }
    }
}
