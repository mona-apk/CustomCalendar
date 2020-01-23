package com.monapk.customcalendar.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.monapk.customcalendar.R
import com.monapk.customcalendar.util.DayAdapter
import kotlinx.android.synthetic.main.custom_calendar.view.*
import java.util.*

class CalendarView(context: Context, attributeSet: AttributeSet?) : ConstraintLayout(context,attributeSet) {

    private var layout : View = LayoutInflater.from(context).inflate(R.layout.custom_calendar, this)

    private val calJ : Calendar = Calendar.getInstance()

    private lateinit var dayAdapter : DayAdapter
    private lateinit var listOfDay: MutableList<Int>

    private var year : Int = 2020
    private var month : Int = 1
    private var day : Int = 1
    private var dow : Int = 1//曜日,SUNDAY = 1といった列挙型みたいな整数

    //画面にViewが描写された後の実装を記述
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        init()//日付の初期化
        listOfDay = getData()
        dayAdapter = DayAdapter(listOfDay)
        layout.calendar_recycler_view.apply{
            this.setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,7)
            adapter = dayAdapter
        }
        layout.prev.setOnClickListener {
            changeMonth(-1)
        }
        layout.next.setOnClickListener {
            changeMonth(1)
        }
    }

    private fun init() {
        year = calJ.get(Calendar.YEAR)
        month = calJ.get(Calendar.MONTH)
        day = calJ.get(Calendar.DATE)
        //1日の曜日が欲しい
        calJ.set(year, month,1)
        dow = calJ.get(Calendar.DAY_OF_WEEK)
    }

    private fun getData() : MutableList<Int> {
        val listOfDay: MutableList<Int> = mutableListOf()
        //月の日数を取得
        val lastDay : Int = calJ.getActualMaximum(Calendar.DATE)
        for (i in 0 until (dow - 1) ){
            listOfDay.add(0)
        }
        for (i in 1 until lastDay + 1 ) {
            listOfDay.add(i)
        }
        return listOfDay
    }

    private fun changeMonth(p:Int) {
        calJ.add(Calendar.MONTH,p)
        init()
        listOfDay = getData()
        dayAdapter.upDateList(listOfDay)
    }


}








