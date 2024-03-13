package com.example.immagic.nawigation.categories.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    private val _categories = MutableLiveData<List<CategoryModel>>()
    val categories: LiveData<List<CategoryModel>> get() = _categories

    private val _quotesContent = MutableLiveData<List<String>>()
    val quotesContent: LiveData<List<String>> get() = _quotesContent

    init {

        viewModelScope.launch {
            val result = categoryRepository.getCategories()
            _categories.value = result
        }
    }

    fun getQuotesContent(cardSetId: Int): List<String> {
        return emptyList()
    }


}
