package com.example.immagic.nawigation.categories.category

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.nawigation.categories.OnSettingItemClickListenerCategory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.Type

class CategoryFragment : Fragment() {

    private lateinit var categoriesRc: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryList: MutableList<CategoryModel>
    private lateinit var allFiltrBtn: Button
    private lateinit var unlockedFilterBtn: Button
    private lateinit var premiumFilterBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category_layout, container, false)

        allFiltrBtn = view.findViewById(R.id.allFiltr)
        unlockedFilterBtn = view.findViewById(R.id.unlockedFiltr)
        premiumFilterBtn = view.findViewById(R.id.premiumFiltr)
        categoriesRc = view.findViewById(R.id.categoriesRc)

        categoriesRc.layoutManager = GridLayoutManager(requireContext(), 2)
        categoryAdapter = CategoryAdapter(requireContext(), ArrayList())
        categoriesRc.adapter = categoryAdapter

        loadCategories()
        allFiltrBtn.setOnClickListener {
            setButtonState(allFiltrBtn)
            filterData("all")
        }
        unlockedFilterBtn.setOnClickListener {
            setButtonState(unlockedFilterBtn)
            filterData("unlocked")
        }
        premiumFilterBtn.setOnClickListener {
            setButtonState(premiumFilterBtn)
            filterData("premium")
        }


        setButtonState(allFiltrBtn)// Ustawienie domyślnego stanu początkowego
        return view
    }

    private fun loadCategories() {
        val categoryRepository: CategoryRepository = CategoryRepositoryImp(requireContext())

        CoroutineScope(Dispatchers.Main).launch {
            try {
                categoryList = categoryRepository.getCategories().toMutableList()
                categoryAdapter.setDataList(categoryList)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun filterData(filterType: String) {
        val filteredList = when (filterType) {
            "all" -> categoryList.toList()
            "unlocked" -> categoryList.filter { it.availability == 1 }
            "premium" -> categoryList.filter { it.type == "premium" }
            else -> categoryList.toList()
        }
        categoryAdapter.setDataList(filteredList.toMutableList())
    }

    private fun setButtonState(selectedButton: Button) {

        allFiltrBtn.setBackgroundResource(R.drawable.rounded_rectangle_default)
        unlockedFilterBtn.setBackgroundResource(R.drawable.rounded_rectangle_default)
        premiumFilterBtn.setBackgroundResource(R.drawable.rounded_rectangle_default)

        allFiltrBtn.setTextColor(ContextCompat.getColor(requireContext(),R.color.text_common))
        unlockedFilterBtn.setTextColor(ContextCompat.getColor(requireContext(),R.color.text_common))
        premiumFilterBtn.setTextColor(ContextCompat.getColor(requireContext(),R.color.text_common))

        allFiltrBtn.setTypeface(null, Typeface.NORMAL)
        unlockedFilterBtn.setTypeface(null,Typeface.NORMAL)
        premiumFilterBtn.setTypeface(null, Typeface.NORMAL)


        val anim = AnimationUtils.loadAnimation(context, R.anim.background_fade_in)
        selectedButton.startAnimation(anim)

        selectedButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.corner_dark_violet))
        selectedButton.setBackgroundResource(R.drawable.category_filter_bg)
        selectedButton.setTypeface(null, Typeface.BOLD)
    }

}
