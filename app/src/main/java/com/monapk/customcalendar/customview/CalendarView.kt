package com.monapk.customcalendar.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.monapk.customcalendar.R
import com.monapk.customcalendar.util.DayAdapter
import kotlinx.android.synthetic.main.custom_calendar.view.*


class CalendarView(context: Context, attributeSet: AttributeSet?) : ConstraintLayout(context,attributeSet) {
    private var layout : View = LayoutInflater.from(context).inflate(R.layout.custom_calendar, this)
    private val dayAdapter = DayAdapter()
    //画面にViewが描写された後の実装を記述
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        layout.calendar_recycler_view.apply{
            this.setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,7)
            adapter = dayAdapter

        }
    }
}








