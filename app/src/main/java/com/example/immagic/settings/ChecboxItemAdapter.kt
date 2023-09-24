package com.example.immagic.settings
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R

class CheckboxListAdapter(
    private val context: Context,
    private val dataList: ArrayList<ItemModelCheckboxIcon>,
    private val onItemClick: (Int, Boolean) -> Unit
) : RecyclerView.Adapter<CheckboxListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.setting_item_icon_text_checkbox, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("DiscouragedApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.checkBox.text = item.text
        holder.checkBox.isChecked = item.isChecked


        val resId = context.resources.getIdentifier(item.iconName, "drawable", context.packageName)
        holder.imageView.setImageResource(resId)




        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            onItemClick(position, isChecked)

        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBoxText)
        val imageView: ImageView = itemView.findViewById(R.id.settingIcon)
    }


}
