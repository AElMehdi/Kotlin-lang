package com.aelmehdi.koans

class Introduction

fun main(args: Array<String>) {
    println(start())
    println(joinOptions(mutableListOf("option 1", "option 2", "option 3", "option 4")))
}


// Hello World
fun start(): String = "OK"

// Named and default parameters
fun joinToString(seperator: String = ",", prefix: String = "", postfix: String = ""): String {
    return "I've been called"
}

fun joinOptions(options: Collection<String>): String = joinToString(prefix = "[", postfix = "]")

