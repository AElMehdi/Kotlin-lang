package com.aelmehdi.koans

import com.aelmehdi.koans.TimeInterval.DAY
import com.aelmehdi.koans.TimeInterval.WEEK
import java.util.*

fun nextDay() = addTimeIntervals(DAY, 1)

enum class TimeInterval {

    DAY,
    WEEK,
    YEAR
}

fun addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
    val c = Calendar.getInstance()
//    c.set(MyDate.year, MyDate.month, MyDate.dayOfMonth)
    when (timeInterval) {
        DAY -> c.add(Calendar.DAY_OF_MONTH, number)
        WEEK -> c.add(Calendar.WEEK_OF_MONTH, number)
        TimeInterval.YEAR -> c.add(Calendar.YEAR, number)
    }
}
