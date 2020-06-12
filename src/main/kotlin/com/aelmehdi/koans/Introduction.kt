package com.aelmehdi.koans

import java.util.*

class Introduction

fun main(args: Array<String>) {
    println(start())
    println(joinOptions(mutableListOf("option 1", "option 2", "option 3", "option 4")))
    println(containsEven(mutableListOf(3, 1, 5, 7)))
    println(getPattern())
    println(getPeople())
    println(eval(Num(15)))
    println(eval(Sum(Num(10), Num(10))))
    println(18.r())
    println(Pair(20, 15).r())
    println(getList()) // 9 7 1
    println(getListSAM()) // 9 7 1
}


// Hello World
fun start(): String = "OK"

// Named and default parameters
fun joinToString(seperator: String = ",", prefix: String = "", postfix: String = ""): String {
    return "I've been called"
}

fun joinOptions(options: Collection<String>): String = joinToString(prefix = "[", postfix = "]")


// Lambdas
fun containsEven(numbers: Collection<Int>) = numbers.any { it % 2 == 0 }

// Strings
const val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2} $month \d{4}"""

// Data classes
data class Person(var name: String, var age: Int)

fun getPeople(): List<Person> {
    return listOf(Person("Alice", 29), Person("Bob", 31))
}

// Nullable types
fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    val email = client?.PersonalInfo?.email
    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }
}

class Client(val PersonalInfo: PersonalInfo?)

class PersonalInfo(val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}

// Smart casts
fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
        else -> throw IllegalArgumentException("Unknown Expression")
    }


interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

// Extension functions
fun Int.r(): RationalNumber = RationalNumber(this, 1)

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)


data class RationalNumber(val numerator: Int, val denominator: Int)

// Object expressions

fun getList(): List<Int> {
    val myList = mutableListOf<Int>(7, 1, 9)

    Collections.sort(myList, object : Comparator<Int> {
        override fun compare(x: Int, y: Int): Int {
            return y - x
        }
    })
    return myList
}

// SAM Conversions

fun getListSAM(): List<Int> {
    val myList = mutableListOf<Int>(7, 1, 9)

    myList.sortWith(Comparator { x, y -> y - x })

    return myList
}

