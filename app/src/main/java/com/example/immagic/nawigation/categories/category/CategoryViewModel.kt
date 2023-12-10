package com.example.immagic.nawigation.categories.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// Przykładowe użycie w kontekście Android, na przykład wewnątrz ViewModel

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    private val _categories = MutableLiveData<List<CategoryModel>>()
    val categories: LiveData<List<CategoryModel>> get() = _categories

    init {
        // Wywołaj getCategories w momencie utworzenia ViewModel
        viewModelScope.launch {
            val result = categoryRepository.getCategories()
            _categories.value = result
        }
    }

    // Możesz także utworzyć dodatkowe metody w ViewModel do obsługi wyników, błędów itp.
}
