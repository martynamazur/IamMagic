package com.example.immagic.homepage

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.FragmentManager

import com.example.immagic.R


class CourseAdapterVertical(
    private val userCourseProgressList: List<CourseProgressModel>,
    private val childFragmentManager: FragmentManager,
    private val context: Context
) : RecyclerView.Adapter<CourseAdapterVertical.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.action_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userCourseProgress = userCourseProgressList[position]

        // Ustawienie nazwy kursu
        holder.courseNameTextView.text = userCourseProgress.courseName

        // Ustawienie kolorów i atrybutu useLevel
        val outlineWidth = 10 // Adjust the outline width as needed
        val layerDrawable = getLayerDrawable(context, userCourseProgress, outlineWidth)
        holder.progressBar.progressDrawable = layerDrawable

        holder.progressBar.progress = userCourseProgress.level_up_points

        holder.itemView.setOnClickListener {
            val temporrayId = 1

            val bottomSheetFragment = HalfScreenBottomSheetDialogFragment(temporrayId.toString())
            bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)

        }
    }

    override fun getItemCount(): Int {
        return userCourseProgressList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseNameTextView: TextView = itemView.findViewById(R.id.courseNameTextView)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBarCourse)
    }

    private fun getColoredOutlineDrawable(context: Context, outlineColor: Int, outlineWidth: Int): Drawable {
        val gradientDrawable = GradientDrawable()
        gradientDrawable.shape = GradientDrawable.OVAL
        gradientDrawable.setStroke(outlineWidth, outlineColor)
        //gradientDrawable.setColor(Color.TRANSPARENT) // Set inner color to transparent
        return gradientDrawable
    }



    private fun getLayerDrawable(context: Context, userCourseProgress: CourseProgressModel, outlineWidth: Int): LayerDrawable {
        val startColor: Int
        val endColor: Int

        when (userCourseProgress.level) {
            1 -> {
                startColor = Color.parseColor("#BFEDF7")
                endColor = Color.parseColor("#C6FDF3")
            }
            2 -> {
                startColor = Color.parseColor("#BFF2DC")
                endColor = Color.parseColor("#F8F3B9")
            }
            3 -> {
                startColor = Color.parseColor("#BFE0F6")
                endColor = Color.parseColor("#D6C3FC")
            }
            4 -> {
                startColor = Color.parseColor("#BFB3DC")
                endColor = Color.parseColor("#FEB4CB")
            }
            else -> {
                startColor = ContextCompat.getColor(context, R.color.locked_course_grey)
                endColor = startColor
            }
        }

        val stateShape = getColoredOutlineDrawable(context, startColor, outlineWidth)

        val layers = arrayOf(stateShape)

        return LayerDrawable(layers)
    }


}

