package com.adventofcode

import java.io.File

fun day1_task1() {
    val lines = File("res/day1.txt").readLines()
    val result = lines.mapNotNull { it.toIntOrNull() }.fold(0) { acc, next -> acc + next }
    println(result)
}

fun day1_task2() {
    val lines = File("res/day1.txt").readLines()
    val offsets = lines.mapNotNull { it.toIntOrNull() }

    val seenFrequencies = ArrayList<Int>()
    var sum = 0
    while (true) {
        offsets.forEach {
            sum += it
            if (seenFrequencies.contains(sum)) {
                println(sum)
                return
            }
            seenFrequencies.add(sum)
        }
    }
}