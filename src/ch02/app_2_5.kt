package ch02

import java.io.BufferedReader
import java.io.StringReader

/**
 * Created by lambor on 17-5-24.
 * Exceptions in Kotlin
 */

fun percentage(number:Int) = if(number in 0..100)
    number else
    throw IllegalArgumentException("A percentage value must be between 0 and 100: ${number}")

fun readNumber(reader:BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e:NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

fun readNumber2(reader:BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e:NumberFormatException) {
        return
    }

    println(number)
}

fun readNumber3(reader:BufferedReader):Int? = try {
    Integer.parseInt(reader.readLine())
} catch (e:NumberFormatException) {
    null
}

fun main(args: Array<String>) {
    percentage(100)

    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))

    println(readNumber2(BufferedReader(StringReader("not a number")))) //kotlin.Unit

    println(readNumber3(BufferedReader(StringReader("not a number"))))
}

