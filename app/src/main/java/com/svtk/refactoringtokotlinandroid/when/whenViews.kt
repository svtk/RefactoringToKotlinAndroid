package com.svtk.refactoringtokotlinandroid

import android.view.View
import android.widget.CalendarView
import android.widget.CompoundButton
import android.widget.EditText
import java.util.*

fun fillView(view: View) {
    if (view is EditText) {
        view.setText("default text")
    }
    else if (view is CompoundButton) {
        view.isChecked = true
    }
    else if (view is CalendarView) {
        view.date = currentTime()
    }
}

fun fillView1(view: View) {
    when (view) {
        is EditText -> view.setText("default text")
        is CompoundButton -> view.isChecked = true
//        is Button -> view.performClick()
        is CalendarView -> view.date = currentTime()
    }
}

fun currentTime() = Calendar.getInstance().get(Calendar.SECOND).toLong()
