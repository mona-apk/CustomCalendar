package com.monapk.customcalendar.util

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.monapk.customcalendar.R
import com.monapk.customcalendar.databinding.DayItemBinding
import kotlinx.android.synthetic.main.day_item.view.*
import kotlinx.coroutines.*

//TODO:外部から何かしらのリストを引数に
class DayAdapter(private var listOfDay: MutableList<Int>) : RecyclerView.Adapter<DayAdapter.DayViewHolder>() ,
    ClickListener {

    fun upDateList(listOfInt: MutableList<Int>){
        listOfDay = listOfInt
        notifyDataSetChanged()
    }

    //view holderの作成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<DayItemBinding>(inflater, R.layout.day_item,parent,false)
        return DayViewHolder(view)
    }

    override fun getItemCount(): Int = listOfDay.size

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        if (listOfDay[position] == 0) {
            holder.view.day = ""
        }else{
            holder.view.day = listOfDay[position].toString()
            holder.view.listener = this
        }
    }

    //TAPされた時の記述
    override fun onClicked(v: View) {
        Log.d("tags",v.day_text.text.toString())
    }

    //view holder class
    class DayViewHolder(var view : DayItemBinding) : RecyclerView.ViewHolder(view.root)
}

