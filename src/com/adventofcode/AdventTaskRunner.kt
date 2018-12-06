package com.adventofcode

fun main(args : Array<String>) {
    val day = readNumberInput("Select a day [1-3]:")
    val task = readNumberInput("Select a task [1-2]:")

    when (day) {
        1 -> if (task == 1) day1_task1() else day1_task2()
        2 -> if (task == 1) day2_task1() else day2_task2()
        3 -> if (task == 1) day3_task1() else day3_task2()
        else -> println("Input day not supported")
    }
}

private fun readNumberInput(message: String): Int {
    println(message)
    return readLine()?.toIntOrNull() ?: 1
}
