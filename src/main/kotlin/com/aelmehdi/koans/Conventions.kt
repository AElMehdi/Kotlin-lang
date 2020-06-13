package com.aelmehdi.koans

class Conventions

fun main() {
    val startDate = MyDate(2014, 10, 20)
    val endDate = MyDate(2016, 5, 7)
    println(compare(startDate, endDate)) // true

    print(checkInRange(MyDate(2015, 7, 2), startDate, endDate))
}

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

    operator fun rangeTo(other: MyDate) = DateRange(this, other)
}

fun compare(date1: MyDate, date2: MyDate) = date1 < date2


class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(item: MyDate): Boolean {
        return start <= item && item <= endInclusive
    }
}

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
//    return date in DateRange(first, last)
    return date in first..last
}
