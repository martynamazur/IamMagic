package com.example.immagic.nawigation.categories.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.nawigation.categories.shop.backgrounds.BackgroundsAdapter
import com.example.immagic.nawigation.categories.shop.backgrounds.BackgroundsItemModel
import com.example.immagic.nawigation.categories.shop.boosts.BoostAdapter
import com.example.immagic.nawigation.categories.shop.boosts.BoostersItemModel
import com.example.immagic.nawigation.categories.shop.freez.FreezStreakAdapter
import com.example.immagic.nawigation.categories.shop.freez.FreezStreakItemModel
import com.example.immagic.nawigation.categories.shop.treasurechest.ChestDialogRepositoryImpl
import com.example.immagic.nawigation.categories.shop.treasurechest.ChestDialogViewModel
import com.example.immagic.nawigation.categories.shop.treasurechest.MagicChestAdapter
import com.example.immagic.nawigation.categories.shop.treasurechest.MagicChestItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    private lateinit var puzzlePointsWallet: TextView
    private lateinit var alchemyPointsWallet: TextView

    private lateinit var shopRepositoryImp: ShopRepositoryImp




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.shop_layout, container, false)

        puzzlePointsWallet = view.findViewById(R.id.puzzlePointsWallet)
        alchemyPointsWallet = view.findViewById(R.id.alchemyPointsWallet)
        shopRepositoryImp =ShopRepositoryImp(requireContext())
        setUiWalletBar()


        //Zmienic i wyciagnac z bazy danych informacje + dorobic nowe tabelki
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
        // Inicjalizacja boostList
        boostList = listOf(
            BoostersItemModel(1, "Booster 1", "Booster 1", 2, "Boost 1 description", R.drawable.boostbasicicon, "100", "5 minutes"),
            BoostersItemModel(2, "Booster 2", "Booster 2", 3, "Boost 2 description", R.drawable.boostbasicicon, "500", "10 minutes"),
            BoostersItemModel(3, "Booster 3", "Booster 3", 4, "Boost 3 description", R.drawable.boostbasicicon, "1400", "15 minutes")
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
        val paymentManager = PaymentManager(shopRepository = shopRepositoryImp, requireContext())

        magicChestAdapter = MagicChestAdapter(requireContext(), magicChestList, chestDialogViewModel, chestDialogRepository)
        magicChestRc.adapter = magicChestAdapter


        freezStreakAdapter = FreezStreakAdapter(requireContext(), freezStreakList, paymentManager )
        freezStreakRc.adapter = freezStreakAdapter


        boostAdapter = BoostAdapter(requireContext(), boostList, paymentManager)
        boostersRc.adapter = boostAdapter

        backgroundsAdapter = BackgroundsAdapter(requireContext(), backgroundsList,paymentManager)
        backgroundsRc.adapter = backgroundsAdapter


        magicChestRc.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        freezStreakRc.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        boostersRc.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        backgroundsRc.layoutManager = GridLayoutManager(context, 3)



        removeAddsBtn.setOnClickListener {
            //TODO: Remove adds
        }
        watchAddBtn.setOnClickListener {
            //TODO: Watch add to gain coins
        }



        return view
    }

    private fun setUiWalletBar() {
        lifecycleScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val userCoins = shopRepositoryImp.getUserCoins()
                    val userPuzzle = shopRepositoryImp.getUserPuzzle()

                    withContext(Dispatchers.Main) {
                        alchemyPointsWallet.text = userCoins.toString()
                        puzzlePointsWallet.text = userPuzzle.toString()
                    }
                }
            } catch (_: Exception) {

            }
        }
    }

}
