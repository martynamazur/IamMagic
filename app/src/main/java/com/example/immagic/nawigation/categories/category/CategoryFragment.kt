package com.example.immagic.nawigation.categories.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.nawigation.categories.OnSettingItemClickListenerCategory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryFragment : Fragment() {

    private lateinit var categoriesRc: RecyclerView
    private lateinit var categoryList: List<CategoryModel>
    private lateinit var categoryAdapter: CategoryAdapter





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_category_layout, container, false)
        val categoryRepository: CategoryRepository = CategoryRepositoryImp(requireContext())



        lifecycleScope.launch {
            try {
                categoryList = categoryRepository.getCategories()
                categoryAdapter = CategoryAdapter(requireContext(), categoryList)
                categoriesRc = view.findViewById(R.id.categoriesRc)

                categoriesRc.adapter = categoryAdapter
                categoriesRc.layoutManager = LinearLayoutManager(requireContext())

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        categoriesRc = view.findViewById(R.id.categoriesRc)
        return view
    }



}
