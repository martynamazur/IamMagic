package com.example.immagic.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.loginhistory.LoginManager
import com.example.immagic.nawigation.dailyreward.DailyRewardDialog
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment() : Fragment() {

    private lateinit var dailyRewardDialog: DailyRewardDialog
    private lateinit var loginManager: LoginManager

    private lateinit var levelTopBar: TextView
    private lateinit var energyLvTopBar: TextView
    private lateinit var alchemyBottlesTopBar: TextView

    /*
    Chapter 1

    */
    private lateinit var chapter1SpecialPremium: RecyclerView //horizontal
    private lateinit var chapter1SpecialBasic: RecyclerView   //horizontal

    private lateinit var chapter1SpecialPremiumAdapter: CourseAdapterHorizontal
    private lateinit var chapter1SpecialBasicAdapter: CourseAdapterHorizontal

    private lateinit var chapter1Part1Adapter: CourseAdapterVertical
    private lateinit var chapter1Part2Adapter: CourseAdapterVertical

    private lateinit var chapter1Part1: RecyclerView //4
    private lateinit var chapter1Part2: RecyclerView //2
    private lateinit var chapter1Part3: RecyclerView //2

    /*
    Chapter 2

    */

    private lateinit var chapter2SpecialPremium: RecyclerView //horizontal 2
    private lateinit var chapter2SpecialBasic: RecyclerView   //horizontal 3

    private lateinit var chapter2SpecialPremiumAdapter: CourseAdapterHorizontal
    private lateinit var chapter2SpecialBasicAdapter: CourseAdapterHorizontal

    private lateinit var chapter2Part1Adapter: CourseAdapterVertical
    private lateinit var chapter2Part2Adapter: CourseAdapterVertical
    private lateinit var chapter2Part3Adapter: CourseAdapterVertical


    private lateinit var chapter2Part1: RecyclerView //3
    private lateinit var chapter2Part2: RecyclerView //2
    private lateinit var chapter2Part3: RecyclerView //2

    private lateinit var chapter1SpecialBasicBuy: Button
    private lateinit var chapter1SpecialPremiumBuyPremium: Button

    /*
    Chapter 3

    */

    private lateinit var chapter3SpecialPremium: RecyclerView //horizontal 2
    private lateinit var chapter3SpecialBasic: RecyclerView   //horizontal 3

    private lateinit var chapter3SpecialPremiumAdapter: CourseAdapterHorizontal
    private lateinit var chapter3SpecialBasicAdapter: CourseAdapterHorizontal

    private lateinit var chapter3Part1Adapter: CourseAdapterVertical
    private lateinit var chapter3Part2Adapter: CourseAdapterVertical
    private lateinit var chapter3Part3Adapter: CourseAdapterVertical

    private lateinit var chapter3Part1: RecyclerView //3
    private lateinit var chapter3Part2: RecyclerView //2
    private lateinit var chapter3Part3: RecyclerView //2

    /*
    Chapter 4

    */
    private lateinit var chapter4SpecialPremium: RecyclerView //horizontal
    private lateinit var chapter4SpecialBasic: RecyclerView   //horizontal

    private lateinit var chapter4SpecialPremiumAdapter: CourseAdapterHorizontal
    private lateinit var chapter4SpecialBasicAdapter: CourseAdapterHorizontal

    private lateinit var chapter4Part1Adapter: CourseAdapterVertical
    private lateinit var chapter4Part2Adapter: CourseAdapterVertical
    private lateinit var chapter4Part3Adapter: CourseAdapterVertical

    private lateinit var chapter4Part1: RecyclerView //4
    private lateinit var chapter4Part2: RecyclerView //2

    /*
    Chapter 5

    */

    private lateinit var chapter5SpecialPremium: RecyclerView //horizontal 2
    private lateinit var chapter5SpecialBasic: RecyclerView   //horizontal 3

    private lateinit var chapter5SpecialPremiumAdapter: CourseAdapterHorizontal
    private lateinit var chapter5SpecialBasicAdapter: CourseAdapterHorizontal

    private lateinit var chapter5Part1Adapter: CourseAdapterVertical
    private lateinit var chapter5Part2Adapter: CourseAdapterVertical
    private lateinit var chapter5Part3Adapter: CourseAdapterVertical

    private lateinit var chapter5Part1: RecyclerView //3
    private lateinit var chapter5Part2: RecyclerView //3
    private lateinit var chapter5Part3: RecyclerView //2

    /*
    Chapter 6

    */

    private lateinit var chapter6SpecialPremium: RecyclerView //horizontal 2
    private lateinit var chapter6SpecialBasic: RecyclerView   //horizontal 3

    private lateinit var chapter6SpecialPremiumAdapter: CourseAdapterHorizontal
    private lateinit var chapter6SpecialBasicAdapter: CourseAdapterHorizontal

    private lateinit var chapter6Part1Adapter: CourseAdapterVertical
    private lateinit var chapter6Part2Adapter: CourseAdapterVertical


    private lateinit var chapter6Part1: RecyclerView //3
    private lateinit var chapter6Part2: RecyclerView //3

    /*
  Chapter 7

  */

    private lateinit var chapter7SpecialPremium: RecyclerView //horizontal 2
    private lateinit var chapter7SpecialBasic: RecyclerView   //horizontal 3

    private lateinit var chapter7SpecialPremiumAdapter: CourseAdapterHorizontal
    private lateinit var chapter7SpecialBasicAdapter: CourseAdapterHorizontal

    private lateinit var chapter7Part1Adapter: CourseAdapterVertical
    private lateinit var chapter7Part2Adapter: CourseAdapterVertical


    private lateinit var chapter7Part1: RecyclerView //3
    private lateinit var chapter7Part2: RecyclerView //2


    /*
  Chapter 8

  */

    private lateinit var chapter8SpecialPremium: RecyclerView //horizontal 2
    private lateinit var chapter8SpecialBasic: RecyclerView   //horizontal 3

    private lateinit var chapter8SpecialPremiumAdapter: CourseAdapterHorizontal
    private lateinit var chapter8SpecialBasicAdapter: CourseAdapterHorizontal

    private lateinit var chapter8Part1Adapter: CourseAdapterVertical
    private lateinit var chapter8Part2Adapter: CourseAdapterVertical


    private lateinit var chapter8Part1: RecyclerView //3
    private lateinit var chapter8Part2: RecyclerView //3



    //private val homePageViewModel: HomePageViewModel by viewModel()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        chapter1SpecialPremium = rootView.findViewById(R.id.chapter1SpecialPremium)
        chapter1SpecialBasic = rootView.findViewById(R.id.chapter1SpecialBasic)
        chapter1Part1 = rootView.findViewById(R.id.chapter1Part1)
        chapter1Part2 = rootView.findViewById(R.id.chapter1Part2)
        chapter1Part3 = rootView.findViewById(R.id.chapter1Part3)

        chapter2SpecialPremium = rootView.findViewById(R.id.chapter2SpecialPremium)
        chapter2SpecialBasic = rootView.findViewById(R.id.chapter2SpecialBasic)
        chapter2Part1 = rootView.findViewById(R.id.chapter2Part1)
        chapter2Part2 = rootView.findViewById(R.id.chapter2Part2)
        chapter2Part3 = rootView.findViewById(R.id.chapter2Part3)

        chapter3SpecialPremium = rootView.findViewById(R.id.chapter3SpecialPremium)
        chapter3SpecialBasic = rootView.findViewById(R.id.chapter3SpecialBasic)
        chapter3Part1 = rootView.findViewById(R.id.chapter3Part1)
        chapter3Part2 = rootView.findViewById(R.id.chapter3Part2)
        chapter3Part3 = rootView.findViewById(R.id.chapter3Part3)

        chapter4SpecialPremium = rootView.findViewById(R.id.chapter4SpecialPremium)
        chapter4SpecialBasic = rootView.findViewById(R.id.chapter4SpecialBasic)
        chapter4Part1 = rootView.findViewById(R.id.chapter4Part1)
        chapter4Part2 = rootView.findViewById(R.id.chapter4Part2)

        chapter5SpecialPremium = rootView.findViewById(R.id.chapter5SpecialPremium)
        chapter5SpecialBasic = rootView.findViewById(R.id.chapter5SpecialBasic)
        chapter5Part1 = rootView.findViewById(R.id.chapter5Part1)
        chapter5Part2 = rootView.findViewById(R.id.chapter5Part2)
        chapter5Part3 = rootView.findViewById(R.id.chapter5Part3)

        chapter6SpecialPremium = rootView.findViewById(R.id.chapter6SpecialPremium)
        chapter6SpecialBasic = rootView.findViewById(R.id.chapter6SpecialBasic)
        chapter6Part1 = rootView.findViewById(R.id.chapter6Part1)
        chapter6Part2 = rootView.findViewById(R.id.chapter6Part2)

        chapter7SpecialPremium = rootView.findViewById(R.id.chapter7SpecialPremium)
        chapter7SpecialBasic = rootView.findViewById(R.id.chapter7SpecialBasic)
        chapter7Part1 = rootView.findViewById(R.id.chapter7Part1)
        chapter7Part2 = rootView.findViewById(R.id.chapter7Part2)

        chapter8SpecialPremium = rootView.findViewById(R.id.chapter8SpecialPremium)
        chapter8SpecialBasic = rootView.findViewById(R.id.chapter8SpecialBasic)
        chapter8Part1 = rootView.findViewById(R.id.chapter8Part1)
        chapter8Part2 = rootView.findViewById(R.id.chapter8Part2)



        levelTopBar = rootView.findViewById(R.id.levelTopBar)
        energyLvTopBar = rootView.findViewById(R.id.energyLvTopBar)
        alchemyBottlesTopBar = rootView.findViewById(R.id.alchemyBottlesTopBar)

/*
        homePageViewModel.alchemyBottlesTopBar.observe(viewLifecycleOwner, Observer { alchemyBottles ->
            alchemyBottlesTopBar.text = alchemyBottles
        })

        homePageViewModel.energyLvTopBar.observe(viewLifecycleOwner, Observer { energyLv ->
            energyLvTopBar.text = energyLv
        })

        homePageViewModel.energyLvTopBar.observe(viewLifecycleOwner, Observer { level ->
            levelTopBar.text = level
        })

 */





        dailyRewardDialog = DailyRewardDialog(requireContext())
        loginManager = LoginManager(requireContext())
        //TODO: isRewardClaimed() pokazac jesli spelnione sa 2 warunki - nie odebrano nagrody lub pierwszelogowanie danego dnia
        lifecycleScope.launch {
            if (loginManager.logInto()) {
                dailyRewardDialog.showDialog()
            }
        }



        // Przykładowe dane testowe
       val courseProgressList = listOf(
           CourseProgressModel(id_user = 1, id_cardSet = 101, level = 3, level_up_points = 100, isEverAttendent = true, courseName = "Kurs 1"),
           CourseProgressModel(id_user = 2, id_cardSet = 102, level = 2, level_up_points = 80, isEverAttendent = false, courseName = "Kurs 2"),
           CourseProgressModel(id_user = 3, id_cardSet = 103, level = 4, level_up_points = 120, isEverAttendent = true, courseName = "Kurs 3"),
           CourseProgressModel(id_user = 4, id_cardSet = 103, level = 4, level_up_points = 120, isEverAttendent = true, courseName = "Kurs 3"),
           CourseProgressModel(id_user = 5, id_cardSet = 103, level = 4, level_up_points = 120, isEverAttendent = true, courseName = "Kurs 3"),
           CourseProgressModel(id_user = 6, id_cardSet = 103, level = 4, level_up_points = 120, isEverAttendent = true, courseName = "Kurs 3"),

       )
        val courseProgressListH = listOf(
            CourseProgressModel(id_user = 1, id_cardSet = 101, level = 3, level_up_points = 100, isEverAttendent = true, courseName = "Kurs 1"),
            CourseProgressModel(id_user = 2, id_cardSet = 102, level = 2, level_up_points = 80, isEverAttendent = false, courseName = "Kurs 2"),
            CourseProgressModel(id_user = 3, id_cardSet = 103, level = 4, level_up_points = 120, isEverAttendent = true, courseName = "Kurs 3"),

            )


        // Chapter 1
        chapter1SpecialPremiumAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter1SpecialPremium.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter1SpecialPremium.adapter = chapter1SpecialPremiumAdapter

        chapter1SpecialBasicAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter1SpecialBasic.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter1SpecialBasic.adapter = chapter1SpecialBasicAdapter

        chapter1Part1Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter1Part1.layoutManager = LinearLayoutManager(context)
        chapter1Part1.adapter = chapter1Part1Adapter

        chapter1Part2Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter1Part2.layoutManager = LinearLayoutManager(context)
        chapter1Part2.adapter = chapter1Part2Adapter

        // Chapter 2
        chapter2SpecialPremiumAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter2SpecialPremium.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter2SpecialPremium.adapter = chapter2SpecialPremiumAdapter

        chapter2SpecialBasicAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter2SpecialBasic.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter2SpecialBasic.adapter = chapter2SpecialBasicAdapter

        chapter2Part1Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter2Part1.layoutManager = LinearLayoutManager(context)
        chapter2Part1.adapter = chapter2Part1Adapter

        chapter2Part2Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter2Part2.layoutManager = LinearLayoutManager(context)
        chapter2Part2.adapter = chapter2Part2Adapter

        chapter2Part3Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter2Part3.layoutManager = LinearLayoutManager(context)
        chapter2Part3.adapter = chapter2Part3Adapter



        // Chapter 3
        chapter3SpecialPremiumAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter3SpecialPremium.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter3SpecialPremium.adapter = chapter3SpecialPremiumAdapter

        chapter3SpecialBasicAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter3SpecialBasic.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter3SpecialBasic.adapter = chapter3SpecialBasicAdapter

        chapter3Part1Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter3Part1.layoutManager = LinearLayoutManager(context)
        chapter3Part1.adapter = chapter3Part1Adapter

        chapter3Part2Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter3Part2.layoutManager = LinearLayoutManager(context)
        chapter3Part2.adapter = chapter3Part2Adapter

        chapter3Part3Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter3Part3.layoutManager = LinearLayoutManager(context)
        chapter3Part3.adapter = chapter3Part3Adapter



            // Chapter 4
        chapter4SpecialPremiumAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter4SpecialPremium.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter4SpecialPremium.adapter = chapter4SpecialPremiumAdapter

        chapter4SpecialBasicAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter4SpecialBasic.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter4SpecialBasic.adapter = chapter4SpecialBasicAdapter

        chapter4Part1Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter4Part1.layoutManager = LinearLayoutManager(context)
        chapter4Part1.adapter = chapter4Part1Adapter

        chapter4Part2Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter4Part2.layoutManager = LinearLayoutManager(context)
        chapter4Part2.adapter = chapter4Part2Adapter



        // Chapter 5
        chapter5SpecialPremiumAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter5SpecialPremium.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter5SpecialPremium.adapter = chapter5SpecialPremiumAdapter

        chapter5SpecialBasicAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter5SpecialBasic.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter5SpecialBasic.adapter = chapter5SpecialBasicAdapter

        chapter5Part1Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter5Part1.layoutManager = LinearLayoutManager(context)
        chapter5Part1.adapter = chapter5Part1Adapter

        chapter5Part2Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter5Part2.layoutManager = LinearLayoutManager(context)
        chapter5Part2.adapter = chapter5Part2Adapter

        chapter5Part3Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter5Part3.layoutManager = LinearLayoutManager(context)
        chapter5Part3.adapter = chapter5Part3Adapter



        // Chapter 6
        chapter6SpecialPremiumAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter6SpecialPremium.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter6SpecialPremium.adapter = chapter6SpecialPremiumAdapter

        chapter6SpecialBasicAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter6SpecialBasic.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter6SpecialBasic.adapter = chapter6SpecialBasicAdapter

        chapter6Part1Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter6Part1.layoutManager = LinearLayoutManager(context)
        chapter6Part1.adapter = chapter6Part1Adapter

        chapter6Part2Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter6Part2.layoutManager = LinearLayoutManager(context)
        chapter6Part2.adapter = chapter6Part2Adapter



        // Chapter 7
        chapter7SpecialPremiumAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter7SpecialPremium.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter7SpecialPremium.adapter = chapter7SpecialPremiumAdapter

        chapter7SpecialBasicAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter7SpecialBasic.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter7SpecialBasic.adapter = chapter7SpecialBasicAdapter

        chapter7Part1Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter7Part1.layoutManager = LinearLayoutManager(context)
        chapter7Part1.adapter = chapter7Part1Adapter

        chapter7Part2Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter7Part2.layoutManager = LinearLayoutManager(context)
        chapter7Part2.adapter = chapter7Part2Adapter



        // Chapter 8
        chapter8SpecialPremiumAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter8SpecialPremium.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter8SpecialPremium.adapter = chapter8SpecialPremiumAdapter

        chapter8SpecialBasicAdapter = CourseAdapterHorizontal(courseProgressList, childFragmentManager, requireContext())
        chapter8SpecialBasic.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        chapter8SpecialBasic.adapter = chapter8SpecialBasicAdapter

        chapter8Part1Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter8Part1.layoutManager = LinearLayoutManager(context)
        chapter8Part1.adapter = chapter8Part1Adapter

        chapter8Part2Adapter = CourseAdapterVertical(courseProgressList, childFragmentManager, requireContext())
        chapter8Part2.layoutManager = LinearLayoutManager(context)
        chapter8Part2.adapter = chapter8Part2Adapter



        return rootView
    }
}
