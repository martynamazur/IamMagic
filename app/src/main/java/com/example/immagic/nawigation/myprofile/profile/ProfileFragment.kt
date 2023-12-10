package com.example.immagic.nawigation.myprofile.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.nawigation.myprofile.myaddedcards.MyAddedCards
import com.example.immagic.nawigation.myprofile.myrecordings.MyRecordings
import com.example.immagic.nawigation.myprofile.myshop.MyShop
import com.example.immagic.util.ProfileViewModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileFragment : Fragment() {

    //private val viewModel: ProfileViewModel by viewModels()
    private lateinit var statisticRc: RecyclerView
    private lateinit var statisticAdapter: StatisticAdapter
    private lateinit var statisticModelList: ArrayList<ProfileStatisticModel>



    private lateinit var myCardsProfile: Button
    private lateinit var myRecordings: Button
    private lateinit var shopBtnProfile: Button

    private lateinit var helloName: TextView




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)



        myCardsProfile = view.findViewById(R.id.myCardsProfile)
        myRecordings = view.findViewById(R.id.myRecordings)
        shopBtnProfile = view.findViewById(R.id.shopBtnProfile)
        helloName = view.findViewById(R.id.helloName)

        statisticModelList = ArrayList()
        getUserStatisticInfo()
        setWelcomeMessage()

        statisticRc = view.findViewById(R.id.statisticRc)
        statisticAdapter = StatisticAdapter(statisticModelList)
        statisticRc.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        statisticRc.adapter = statisticAdapter



        // Ładuj dane z bazy danych
        //viewModel.loadDataFromDatabase()



        myCardsProfile.setOnClickListener {
            val intent = Intent(requireContext(), MyAddedCards::class.java)
            startActivity(intent)
        }

        myRecordings.setOnClickListener {
            val intent = Intent(requireContext(), MyRecordings::class.java)
            startActivity(intent)
        }

        shopBtnProfile.setOnClickListener {
            val intent = Intent(requireContext(), MyShop::class.java)
            startActivity(intent)
        }






        return view
    }




    private fun getUserStatisticInfo() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val applicationContext = requireContext().applicationContext
                val db = AppDatabase.getInstance(applicationContext)
                val userDao = db.userDao()
                val streak = userDao.getStreak(1)
                val totalAmountOfCards = userDao.getTotalAmountOfCards(1)
                val totalReadCards = userDao.getTotalReadCards(1)

                withContext(Dispatchers.Main) {

                    statisticModelList.add(ProfileStatisticModel("Streak", streak.toString()))
                    statisticModelList.add(ProfileStatisticModel("Owned Cards", totalAmountOfCards.toString()))
                    statisticModelList.add(ProfileStatisticModel("Read cards", totalReadCards.toString()))
                    println(statisticModelList)
                    statisticAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private  fun setWelcomeMessage(){

        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val username = AppDatabase.getInstance(requireContext()).userDao().getUsername(1)

                withContext(Dispatchers.Main) {
                    helloName.text = "Hello $username"
                }
            }
        }
    }

}
