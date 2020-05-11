package com.ws.jamsholat.activity.ui.scrolldatepick

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ws.jamsholat.R
import com.ws.jamsholat.activity.ui.scrolldatepick.model.DatePickerModel

class DatePickAdapter(private val dataItem: List<DatePickerModel>) : RecyclerView.Adapter<DatePickAdapter.DatePickerViewHolder>() {

    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatePickerViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.day_list_item,parent,false)
        return DatePickerViewHolder(layoutInflater)
    }

    override fun getItemCount() = dataItem.size

    override fun onBindViewHolder(holder: DatePickerViewHolder, position: Int) {
        val currentItem = dataItem[position]

        holder.date.text = currentItem.date?.readable

    }

    class DatePickerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val date: TextView = view.findViewById<TextView>(R.id.day_value)
        val layout: RelativeLayout = view.findViewById<RelativeLayout>(R.id.day_holder)


    }
}


