package com.example.immagic.nawigation.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.immagic.R
import com.example.immagic.nawigation.myprofile.StatisticAdapter


// wnetrze shopu
class ShopFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.shop_layout, container, false)




        return view
    }

}
