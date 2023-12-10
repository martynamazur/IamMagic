package com.example.immagic.nawigation.myprofile.myrecordings

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.example.immagic.R

class MyRecordings: AppCompatActivity() {

    private lateinit var goBackNawigationBtn: ImageButton
    private lateinit var menuBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_recordings)

        goBackNawigationBtn = findViewById(R.id.goBackNawigationBtn)
        menuBtn = findViewById(R.id.menuBtn)


        val transaction = supportFragmentManager.beginTransaction()
        val fragmentEmptyList = MyRecordingsEmptyList()
        val fragmentList = MyRecordingsNotEmptyList()
        val testCzyPustaLista = false // zastąpić odwołaniem do bazy


        if(testCzyPustaLista){
            transaction.replace(R.id.fragmentContainerMyRecordings, fragmentList)
        }else{
            transaction.replace(R.id.fragmentContainerMyRecordings, fragmentEmptyList)
        }
        transaction.addToBackStack(null)
        transaction.commit()

        goBackNawigationBtn.setOnClickListener {  finish() }
        menuBtn.setOnClickListener { view ->
            showPopupMenu(view)
        }

    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.edit_menu)

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.menu_delete_all -> {
                    true
                }
                R.id.menu_delete_selected -> {
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

}
