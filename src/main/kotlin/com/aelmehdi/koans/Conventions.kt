package com.aelmehdi.koans

class Conventions

fun main(args: Array<String>) {
    println(
        compare(
            MyDate(2015, 10, 20),
            MyDate(2016, 5, 7)
        )) // true

}

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

fun compare(date1: MyDate, date2: MyDate) = date1 < date2
