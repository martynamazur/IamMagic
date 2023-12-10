package com.example.immagic.nawigation.categories.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.RoomWarnings
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.database.User
import com.example.immagic.nawigation.categories.shop.BackgroundsAdapter
import com.example.immagic.nawigation.categories.shop.MagicChestAdapter
import com.example.immagic.nawigation.categories.shop.treasurechest.ChestDialogRepository
import com.example.immagic.nawigation.categories.shop.treasurechest.ChestDialogRepositoryImpl
import com.example.immagic.nawigation.categories.shop.treasurechest.ChestDialogViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


// wnetrze shopu
class ShopFragment : Fragment() {

    private lateinit var removeAddsBtn: Button
    private lateinit var watchAddBtn: Button
    private lateinit var magicChestRc: RecyclerView
    private lateinit var freezStreakRc: RecyclerView
    private lateinit var boostersRc: RecyclerView
    private lateinit var backgroundsRc: RecyclerView


    private lateinit var  magicChestAdapter: MagicChestAdapter
    private lateinit var freezStreakAdapter: FreezStreakAdapter
    private lateinit var boostAdapter: BoostAdapter
    private lateinit var backgroundsAdapter: BackgroundsAdapter


    private lateinit var  magicChestList: List<MagicChestItemModel>
    private lateinit var freezStreakList: List<FreezStreakItemModel>
    private lateinit var boostList: List<BoostersItemModel>
    private lateinit var backgroundsList: List<BackgroundsItemModel>

    private lateinit var coinsToolbar: LinearLayout




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.shop_layout, container, false)

        // Inicjalizacja magicChestList
        magicChestList = listOf(
            MagicChestItemModel("Magic Chest 1", R.drawable.basicchest),//
            MagicChestItemModel("Magic Chest 2", R.drawable.basicchest),//TODO: zmienic pozniej na odpowiednie ikony po ich przerobieniu
            MagicChestItemModel("Magic Chest 3", R.drawable.basicchest)
        )

        // Inicjalizacja freezStreakList
        freezStreakList = listOf(
            FreezStreakItemModel("Freez Streak 1", R.drawable.streakbasicicon, "100"),
            FreezStreakItemModel("Freez Streak 2", R.drawable.streakbasicicon, "500"),
            FreezStreakItemModel("Freez Streak 3", R.drawable.streakbasicicon, "1300")
        )

        // Inicjalizacja boostList
        boostList = listOf(
            BoostersItemModel("Booster 1","Booster 1", R.drawable.boostbasicicon, "100"),
            BoostersItemModel("Booster 2","Booster 1", R.drawable.boostbasicicon, "500"),
            BoostersItemModel("Booster 3","Booster 1", R.drawable.boostbasicicon, "1400")
        )

        // Inicjalizacja backgroundsList
        backgroundsList = listOf(
            BackgroundsItemModel("600","5", R.drawable.testbackgrounds ),
            BackgroundsItemModel("2000","20", R.drawable.testbackgrounds ),
            BackgroundsItemModel("2000","40", R.drawable.testbackgrounds ),
            BackgroundsItemModel("5000", "50",R.drawable.testbackgrounds ),

            )


        removeAddsBtn = view.findViewById(R.id.removeAddsBtn)
        watchAddBtn = view.findViewById(R.id.watchAddBtn)

        magicChestRc = view.findViewById(R.id.magicChestRc)
        freezStreakRc = view.findViewById(R.id.freezStreakRc)
        boostersRc = view.findViewById(R.id.boostersRc)
        backgroundsRc = view.findViewById(R.id.backgroundsRc)

        // Inicjalizacja magicChestAdapter
        val chestDialogViewModel = ViewModelProvider(this)[ChestDialogViewModel::class.java]
        val chestDialogRepository = ChestDialogRepositoryImpl(requireContext(), chestDialogViewModel)

        magicChestAdapter = MagicChestAdapter(requireContext(), magicChestList, chestDialogViewModel, chestDialogRepository)
        magicChestRc.adapter = magicChestAdapter



        // Inicjalizacja freezStreakAdapter
        freezStreakAdapter = FreezStreakAdapter(requireContext(), freezStreakList)
        freezStreakRc.adapter = freezStreakAdapter

        // Inicjalizacja boostAdapter
        boostAdapter = BoostAdapter(requireContext(), boostList)
        boostersRc.adapter = boostAdapter

        // Inicjalizacja backgroundsAdapter
        backgroundsAdapter = BackgroundsAdapter(requireContext(), backgroundsList)
        backgroundsRc.adapter = backgroundsAdapter



        magicChestRc.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        freezStreakRc.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        boostersRc.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        backgroundsRc.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)



        removeAddsBtn.setOnClickListener {  }
        watchAddBtn.setOnClickListener {  }



        return view
    }

    suspend fun getUserCoins(): Int{
        return try {
            withContext(Dispatchers.IO){
                val db = AppDatabase.getInstance(requireContext())
                val user = db.userDao()
                user.getAlchemyPoints(1)
            }
        }catch (e: Exception){
            e.printStackTrace()
            throw e
        }
    }

}
