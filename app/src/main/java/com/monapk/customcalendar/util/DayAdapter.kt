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

//TODO:外部から何かしらのリストを引数に
class DayAdapter() : RecyclerView.Adapter<DayAdapter.DayViewHolder>() ,
    ClickListener {

    //一時的
    val mockDays = Array(31) { i -> i}

    //view holderの作成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)

        val view = DataBindingUtil.inflate<DayItemBinding>(inflater, R.layout.day_item,parent,false)
        return DayViewHolder(view)
    }

    //リストの数を取得する
    //TODO: リストのサイズの変更
    override fun getItemCount(): Int = mockDays.size

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.view.day = (mockDays[position] + 1).toString()
        holder.view.listener = this
    }

    //TAPされた時の記述
    override fun onClicked(v: View) {
        Log.d("TAGG",v.day_text.text.toString())
    }

    //view holder class
    class DayViewHolder(var view : DayItemBinding) : RecyclerView.ViewHolder(view.root)
}

