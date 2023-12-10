package com.example.immagic.util

import android.app.Application
import android.content.Intent
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.immagic.database.AppDatabase

import com.example.immagic.nawigation.myprofile.profile.ProfileStatisticModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.nio.channels.Channel

class ProfileViewModel(private val repository: AppDatabase) : ViewModel() {


    private val _uiEvent = MutableLiveData<ProfileUiEvent>()
    val uiEvent: LiveData<ProfileUiEvent> get() = _uiEvent

    private val _welcomeMessage = MutableLiveData<String>()
    val welcomeMessage: LiveData<String> get() = _welcomeMessage

    private val _statistics = MutableLiveData<List<ProfileStatisticModel>>()
    val statistics: LiveData<List<ProfileStatisticModel>> get() = _statistics


    fun loadDataFromDatabase() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val userDao = repository.userDao()
                val streak = userDao.getStreak(1)
                val totalAmountOfCards = userDao.getTotalAmountOfCards(1)
                val totalReadCards = userDao.getTotalReadCards(1)

                withContext(Dispatchers.Main) {
                    // Update LiveData or perform other UI-related tasks here
                    _statistics.value = listOf(
                        ProfileStatisticModel("Streak", streak.toString()),
                        ProfileStatisticModel("Owned Cards", totalAmountOfCards.toString()),
                        ProfileStatisticModel("Read cards", totalReadCards.toString())
                    )
                }
            }
        }
    }
// Metoda, która może być wywoływana w odpowiedzi na różne akcje, np. przygotowanie ekranu.
fun onEvent(event: ProfileUiEvent) {

   }
   // Dodaj inne zdarzenia, jeśli są potrzebne.

}

