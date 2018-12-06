package com.adventofcode

import java.io.File

val rectangleRegex = Regex("""#([0-9]+)\s@\s([0-9]+),([0-9]+):\s([0-9]+)x([0-9]+)""")

data class Loc(val x: Int, val y: Int) {
    operator fun compareTo(loc: Loc): Int {
        var cmp = x - loc.x
        if (cmp == 0) {
            cmp = y - loc.y
        }
        return cmp
    }
}

data class Rect(val id: Int, val left: Int, val top: Int, val width: Int, val height: Int) {

    var tileCount = 0

    fun calcTiles(): List<Loc> {
        val tiles = mutableListOf<Loc>()
        for (x in left..(left + width - 1)) {
            for (y in top..(top + height - 1)) {
                tiles.add(Loc(x, y))
            }
        }
        tileCount = tiles.size
        return tiles
    }
}

fun day3_task1() {
    val lines = File("res/day3.txt").readLines()
    val areaOverlap = lines
        .map {
            val captures = rectangleRegex.findAll(it).first().groupValues
            val rect = Rect(captures[1].toInt(), captures[2].toInt(), captures[3].toInt(), captures[4].toInt(), captures[5].toInt())
            return@map rect.calcTiles()
        }
        .flatten()
        .groupBy { it }
        .filter { it.value.size > 1 }
        .count()

    println("Area overlap: $areaOverlap")
}

fun day3_task2() {
    val lines = File("res/day3.txt").readLines()
    val nonOverlappedRect = lines
        .map {
            val captures = rectangleRegex.findAll(it).first().groupValues
            val rect = Rect(captures[1].toInt(), captures[2].toInt(), captures[3].toInt(), captures[4].toInt(), captures[5].toInt())
            return@map rect.calcTiles().map { rect to it }
        }
        .flatten()
        .groupBy { it.second }
        .filter { it.value.size == 1 }
        .map { it.value.first().first }
        .groupBy { it.id }
        .filter { it.value.size == it.value[0].tileCount }
        .entries
        .first()

    println("Non-overlapping rect: $nonOverlappedRect")
}