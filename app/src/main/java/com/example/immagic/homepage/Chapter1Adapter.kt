package com.example.immagic.homepage

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import com.example.immagic.R
import com.example.immagic.YourBottomSheetDialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Chapter1Adapter(private val userCourseProgressList: List<CourseProgressModel>,private val fragmentManager: FragmentManager) :
    RecyclerView.Adapter<Chapter1Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.action_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userCourseProgress = userCourseProgressList[position]

        // Ustawienie nazwy kursu
        holder.courseNameTextView.text = userCourseProgress.courseName

        when(userCourseProgress.level){

            1 ->{
                holder.progressBar.max = 2
            }

            2 ->{
                holder.progressBar.max = 10
            }

            3 ->{
                holder.progressBar.max = 20
            }

            4 ->{
                holder.progressBar.max = 50
            }

        }

        holder.progressBar.progress = userCourseProgress.level_up_points

        holder.itemView.setOnClickListener {
            //val bottomSheetDialog = YourBottomSheetDialog(holder.itemView.context)
           showDialog(fragmentManager)


            //val bottomSheetDialog = YourBottomSheetDialog(holder.itemView.context)
           // bottomSheetDialog.show()


        }


        // Ustawienie pozostałych informacji z UserCourseProgress
        //holder.levelTextView.text = userCourseProgress.level.toString()
        //holder.levelUpPointsTextView.text = userCourseProgress.level_up_points.toString()
        //holder.isEverAttendentTextView.text = userCourseProgress.isEverAttendent.toString()

        // Tutaj możesz obsłużyć ProgressBar na podstawie innych danych
    }

    private fun showDialog(fragmentManager: FragmentManager) {
        val bottomSheetFragment = YourBottomSheetDialogFragment()

        //val view = LayoutInflater.from(context).inflate(R.layout.your_bottom_sheet_layout, null)

        //view.setBackgroundColor(Color.TRANSPARENT)
        bottomSheetFragment.show(fragmentManager, "XD")

    }




    /*
    val bottomSheetDialog = BottomSheetDialog(context, R.style.MyBottomSheetDialogTheme)

    val view = LayoutInflater.from(context).inflate(R.layout.your_bottom_sheet_layout, null)
    bottomSheetDialog.setContentView(view)
    view.setBackgroundColor(Color.TRANSPARENT)

    // Pozostała konfiguracja BottomSheetDialog
    //val layoutParams = view.layoutParams
    //layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
    //view.layoutParams = layoutParams

    //bottomSheetDialog.window?.setGravity(Gravity.BOTTOM)
    bottomSheetDialog.window?.setWindowAnimations(R.style.DialogAnimation)

    bottomSheetDialog.show()

     */




    override fun getItemCount(): Int {
        return userCourseProgressList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseNameTextView: TextView = itemView.findViewById(R.id.courseNameTextView)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBarCourse)

    }
}
