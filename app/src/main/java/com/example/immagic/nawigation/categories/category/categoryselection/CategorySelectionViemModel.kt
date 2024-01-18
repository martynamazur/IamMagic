package com.example.immagic.nawigation.categories.category.categoryselection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.immagic.nawigation.myprofile.profile.MyProfileRepository
import kotlinx.coroutines.launch

class CategorySelectionViemModel(private val repository: CategorySelectionRepository) : ViewModel() {

    private val _categorySelectionList = MutableLiveData<List<CategorySelectionModel>>()
    val categorySelectionList: LiveData<List<CategorySelectionModel>>
        get() = _categorySelectionList

    private val _getAllPriceOfSubcategories = MutableLiveData<List<SubcategoryPrice>>()
    val getAllPriceOfSubcategories: LiveData<List<SubcategoryPrice>>
        get() = _getAllPriceOfSubcategories



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

}

