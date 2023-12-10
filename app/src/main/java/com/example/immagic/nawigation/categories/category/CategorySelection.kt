package com.example.immagic.nawigation.categories.category

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R

class CategorySelection: AppCompatActivity() {

    private lateinit var categorySelectionRc: RecyclerView
    private lateinit var categorySelectionList: List<CategorySelectionModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_selection)

        // Retrieve data from intent
        val categoryId = intent.getStringExtra("categoryId")
        val categoryName = intent.getStringExtra("categoryName")

    }

}
