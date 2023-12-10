package com.example.immagic.nawigation.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.immagic.R
import com.example.immagic.nawigation.categories.category.CategoryFragment

class EmptyNotificationListFragment : Fragment() {

    private lateinit var addNewNotification : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.empty_notification_list, container, false)
        addNewNotification = view.findViewById(R.id.addNewNotificationBtn)

        addNewNotification.setOnClickListener {
            val intent = Intent(requireContext(), CategoryFragment::class.java)
            startActivity(intent)
        }


        return view
    }
}