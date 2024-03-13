package com.example.immagic.nawigation.myprofile.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R

import com.example.immagic.nawigation.myprofile.myaddedcards.MyAddedCards
import com.example.immagic.nawigation.myprofile.myequipment.MyEquipment

import kotlinx.coroutines.launch


import org.koin.androidx.viewmodel.ext.android.viewModel



class ProfileFragment : Fragment() {

    private val profileViewModel: MyProfileViewModel by viewModel()

    private lateinit var statisticRc: RecyclerView
    private lateinit var statisticAdapter: StatisticAdapter
    private lateinit var statisticModelList: ArrayList<ProfileStatisticModel>



    private lateinit var myCardsProfile: Button

    private lateinit var myEquipment: Button

    private lateinit var helloName: TextView
    private lateinit var userLevel: TextView
    private lateinit var joinedDate: TextView




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)



        myCardsProfile = view.findViewById(R.id.myCardsProfile)
        myEquipment = view.findViewById(R.id.equipmentBtnProfile)
        helloName = view.findViewById(R.id.helloName)

        //statisticModelList = profileViewModel.userStatistics// przypisac zworcona z bazy danych


        statisticRc = view.findViewById(R.id.statisticRc)
        statisticAdapter = StatisticAdapter(ArrayList())
        statisticRc.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        statisticRc.adapter = statisticAdapter

        profileViewModel.userStatistics.observe(viewLifecycleOwner) { newStatistics ->
            // Update the RecyclerView adapter with the new data
            statisticAdapter.updateData(newStatistics)
        }

        profileViewModel.helloName.observe(viewLifecycleOwner
        ) { newName -> helloName.text = newName }


        lifecycleScope.launch {
            profileViewModel.fetchHelloName()
        }


        myCardsProfile.setOnClickListener {
            val intent = Intent(requireContext(), MyAddedCards::class.java)
            startActivity(intent)
        }



        myEquipment.setOnClickListener {
            val intent = Intent(requireContext(), MyEquipment::class.java)
            startActivity(intent)

        }
        
        return view
    }

}
