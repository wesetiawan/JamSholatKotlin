package com.ws.jamsholat.activity.ui.scrolldatepick

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ws.jamsholat.R
import com.ws.jamsholat.model.calendar.DataItem

class DatePickAdapter(private val dataItem: List<DataItem>, private val firstItem: Int) :
    RecyclerView.Adapter<DatePickAdapter.DatePickerViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatePickerViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val item = layoutInflater.inflate(R.layout.day_list_item, parent, false)
        return DatePickerViewHolder(item)
    }

    override fun getItemCount(): Int = dataItem.size

    override fun onBindViewHolder(holder: DatePickerViewHolder, position: Int) {
        val iDatePicker = context as IDatePicker


        iDatePicker.onLoadDate(dataItem[firstItem], position)

        holder.date.text = (position + 1).toString()


        holder.layout.setOnClickListener(View.OnClickListener {
            iDatePicker.onDateClick(dataItem[position], position)
        })

    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    class DatePickerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById<TextView>(R.id.day_value)
        val layout: CardView = view.findViewById<CardView>(R.id.cv_day_holder)

    }


}


