package com.aelmehdi.koans

class Introduction

fun main(args: Array<String>) {
    println(start())
    println(joinOptions(mutableListOf("option 1", "option 2", "option 3", "option 4")))
    println(containsEven(mutableListOf(3, 1, 5, 7)))
    println(getPattern())
    println(getPeople())
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
