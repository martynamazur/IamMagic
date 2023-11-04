package com.example.immagic.nawigation.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.nawigation.myprofile.StatisticAdapter

class CategoryFragment : Fragment(), OnSettingItemClickListenerCategory {

    private lateinit var categoriesRc: RecyclerView
    private lateinit var categoryList: ArrayList<CategoryModel>
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_category_layout, container, false)


        categoryList = ArrayList()

        categoryAdapter = CategoryAdapter(this, requireContext(), categoryList)
        categoriesRc = view.findViewById(R.id.categoriesRc)
        return view
    }
    override fun onSettingItemClickedCategory(position: Int) {
        val categoryId = categoryList[position].categoryId
        // Perform actions with the retrieved categoryId
    }
}
