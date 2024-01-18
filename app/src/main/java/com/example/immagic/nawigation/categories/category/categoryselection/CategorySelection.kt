package com.example.immagic.nawigation.categories.category.categoryselection

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import org.koin.androidx.viewmodel.ext.android.viewModel
class CategorySelection: AppCompatActivity() {

    private val subcategoryViewModel: CategorySelectionViemModel by viewModel()

    private lateinit var categorySelectionRc: RecyclerView
    private lateinit var subcategoryAdapter: SubcategoryAdapter
    private lateinit var categorySelectionList: ArrayList<CategorySelectionModel>
    private lateinit var subcategoryPriceList: ArrayList<SubcategoryPrice>

    private lateinit var subcategoryGoBackBtn: ImageButton
    private lateinit var subcategoryName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_selection)


        val categoryId = intent.getStringExtra("categoryId")
        val categoryName = intent.getStringExtra("categoryName")

        subcategoryGoBackBtn = findViewById(R.id.equipmentGoBackBtn)
        categorySelectionRc = findViewById(R.id.subcategoryRc)
        subcategoryName = findViewById(R.id.subcategoryName)

        subcategoryName.text = categoryName
        subcategoryGoBackBtn.setOnClickListener {
            finish()
        }

        categorySelectionList = ArrayList()
        subcategoryPriceList = ArrayList()

        val layoutManager = GridLayoutManager(this, 2)
        categorySelectionRc.layoutManager = layoutManager

        subcategoryAdapter = SubcategoryAdapter(categorySelectionList, subcategoryPriceList)
        categorySelectionRc.adapter = subcategoryAdapter


        subcategoryViewModel.categorySelectionList.observe(this) { updatedList ->
            val sortedList = updatedList.sortedBy{ it.lockedStatus }

            categorySelectionList.clear()
            categorySelectionList.addAll(sortedList)
            subcategoryAdapter.notifyDataSetChanged()
        }

        subcategoryViewModel.getAllPriceOfSubcategories.observe(this, {updatedList ->
            subcategoryPriceList.clear()
            subcategoryPriceList.addAll(updatedList)
            subcategoryAdapter.notifyDataSetChanged()
        })


        if (categoryId != null) {
            subcategoryViewModel.fetchData(categoryId.toInt())
        }
    }
}
