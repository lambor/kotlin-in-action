package ch03

/**
 * Created by lambor on 17-5-24.
 * Creating collections in Kotlin
 */

fun main(args: Array<String>) {
    val set = setOf(1,7,53)

    val list = listOf(1,7,53)
    val map = mapOf(1 to "one",7 to "seven",53 to "fifty-three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    val strings = listOf("first","second","fourteenth")
    println(strings.last())

    val numbers = setOf(1,14,2)
    println(numbers.max())
}

