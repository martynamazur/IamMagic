package com.example.immagic.nawigation.categories.category.categoryselection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.immagic.nawigation.myprofile.profile.MyProfileRepository
import kotlinx.coroutines.launch

class CategorySelectionViewModel(
    private val repository: CategorySelectionRepository,
    private val repositoryUser: MyProfileRepository
) : ViewModel() {

    private val _categorySelectionList = MutableLiveData<List<CategorySelectionModel>>()
    val categorySelectionList: LiveData<List<CategorySelectionModel>>
        get() = _categorySelectionList

    private val _getAllPriceOfSubcategories = MutableLiveData<List<SubcategoryPrice>>()
    val getAllPriceOfSubcategories: LiveData<List<SubcategoryPrice>>
        get() = _getAllPriceOfSubcategories


    private val _walletBalance = MutableLiveData<Int>()
    val walletBalance: LiveData<Int>
        get() = _walletBalance

    fun updateWalletBalance(newBalance: Int) {
        _walletBalance.value = newBalance
    }

    public fun fetchData(subCategoryId: Int) {
        viewModelScope.launch {
            // Pobieranie danych z repozytorium
            val data = repository.getSubcategories(subCategoryId)
            _categorySelectionList.postValue(data)

            // Pobieranie danych dotyczących cen
           // val pricesData = repository.getAllSubcategoriesPrices()
            //_subcategoryPricesMap.postValue(pricesData)
        }
    }

    private fun fetchWalletBalance() {
        viewModelScope.launch {
            try {
                val balance = repositoryUser.getWalletBalance()
                _walletBalance.postValue(balance)
            } catch (e: Exception) {
                // Obsłuż błąd pobierania salda portfela
                e.printStackTrace()
            }
        }
    }

    fun updateCategoryAvailability(newStatus: Int, categoryId: Int) {
        viewModelScope.launch {
            repository.updateCategoryAvailability(newStatus, categoryId)
        }
    }

}

