package com.adventofcode

import java.io.File

fun day2_task1() {
    val lines = File("res/day2.txt").readLines()

    var doublesCount = 0
    var triplesCount = 0

    lines.forEach { id ->
        val charCounts = id.toCharArray().distinct().map { char -> id.count { it == char } }
        charCounts.find { it == 2 }?.let { doublesCount++ }
        charCounts.find { it == 3 }?.let { triplesCount++ }
    }

    val checkSum = doublesCount * triplesCount
    println("Checksum = $checkSum")
}

fun day2_task2() {
    val lines = File("res/day2.txt").readLines()

    lines.forEach { first ->
        lines.forEach { second ->
            val charMatches = first.filterIndexed { index, c -> c == second[index] }
            if (charMatches.length == first.length - 1) {
                println("Matched characters: $charMatches")
                return
            }
        }
    }
}