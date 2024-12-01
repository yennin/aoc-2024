import kotlin.math.abs

fun main() {


    fun part1(input: List<String>): Int {
        var (first, second) = splitInput(input)

        first = first.sorted()
        second = second.sorted()
        var distance = 0
        for (i in first.indices) {
            distance += abs(first[i] - second[i])
        }
        return distance
    }

    fun part2(input: List<String>): Int {
        val (first, second) = splitInput(input)
        return first.sumOf { firstNumber -> second.count { it == firstNumber } * firstNumber }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

fun splitInput(input: List<String>) = input.map {
    val split = it.split("   ")
    Pair(split[0].trim().toInt(), split[1].trim().toInt())
}.unzip()


