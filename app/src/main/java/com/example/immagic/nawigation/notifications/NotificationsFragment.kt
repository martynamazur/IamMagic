package com.example.immagic.nawigation.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.immagic.R


class NotificationsFragment : Fragment() {

    private lateinit var addNewNotification: ImageButton
    private lateinit var editNotificationMenu: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =inflater.inflate(R.layout.fragment_notifications, container, false)

        addNewNotification = view.findViewById(R.id.addNewNotification)
        editNotificationMenu = view.findViewById(R.id.editNotificationMenu)

        val transaction = childFragmentManager.beginTransaction()
        val fragmentEmptyList = EmptyNotificationListFragment()
        val fragmentList = NotificationListFragment()
        val testCzyPustaLista = true //zastapic odwolaniem do bazy


        if (testCzyPustaLista) {
           transaction.replace(R.id.fragmentContainerNotification, fragmentEmptyList)
        } else {
            //ustaw widocznosc 2 przyciskow na visible
            transaction.replace(R.id.fragmentContainerNotification, fragmentList)
        }

        transaction.addToBackStack(null)
        transaction.commit()



        addNewNotification.setOnClickListener {
            //przechodzi do listy z kategoriami
        }

        editNotificationMenu.setOnClickListener {
            //1. Wyłacz wszystkie powiadomienia
            // 2. Usun
        }

        return view
    }

    }

