package com.example.immagic.nawigation.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.createnotification.NotificationModel

class NotificationListFragment: Fragment() {

    private lateinit var notificationListRc: RecyclerView
    private lateinit var notificationList: ArrayList<NotificationModel>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_notification_list, container, false)
        //notificationListRc = view.findViewById(R.id.notificationListRc)


        return view
    }

}
