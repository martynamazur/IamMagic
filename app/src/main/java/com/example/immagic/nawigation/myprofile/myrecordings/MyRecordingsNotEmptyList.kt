package com.example.immagic.nawigation.myprofile.myrecordings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.immagic.R

class MyRecordingsNotEmptyList: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_my_recordings_list_not_empty,container,false)

        return view
    }

}
