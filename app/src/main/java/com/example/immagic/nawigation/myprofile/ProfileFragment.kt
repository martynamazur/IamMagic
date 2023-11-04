package com.example.immagic.nawigation.myprofile
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.database.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class ProfileFragment : Fragment() {

    private lateinit var statisticRc: RecyclerView
    private lateinit var statisticAdapter: StatisticAdapter
    private lateinit var statisticModelList: ArrayList<ProfileStatisticModel>



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        statisticModelList = ArrayList()
        getUserStatisticInfo()

        statisticRc = view.findViewById(R.id.statisticRc)
        statisticAdapter = StatisticAdapter(statisticModelList)
        statisticRc.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        statisticRc.adapter = statisticAdapter


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

}
