package com.example.immagic.nawigation

import com.example.immagic.homepage.Chapter1Adapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.homepage.CourseProgressModel

class HomeFragment : Fragment() {

    private lateinit var rcTest: RecyclerView
   // private lateinit var modelList:
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        rcTest = rootView.findViewById(R.id.testRecycler)



       // Aby zapełnic potzrebuje id_cardSet,courseName, amountOfCards + progress uzytkownika z tabelki UserCourseProgress
       // adapter

       // Przykładowe dane testowe
       val courseProgressList = listOf(
           CourseProgressModel(id_user = 1, id_cardSet = 101, level = 3, level_up_points = 100, isEverAttendent = true, courseName = "Kurs 1"),
           CourseProgressModel(id_user = 2, id_cardSet = 102, level = 2, level_up_points = 80, isEverAttendent = false, courseName = "Kurs 2"),
           CourseProgressModel(id_user = 3, id_cardSet = 103, level = 4, level_up_points = 120, isEverAttendent = true, courseName = "Kurs 3"),

       )

       val adapter = Chapter1Adapter(courseProgressList, childFragmentManager)
       val layoutManager = LinearLayoutManager(context)
       rcTest.layoutManager = layoutManager



       rcTest.adapter= adapter


        return rootView
    }
}
