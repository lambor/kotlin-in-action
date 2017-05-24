package ch02

import java.util.*

/**
 * Created by lambor on 17-5-24.
 * Iterating over things: 'while' and 'for' loops
 */
fun fizzBuzz(i:Int) = when {
    i%15==0 -> "FizzBuzz"
    i%3 ==0 -> "Fizz"
    i%5 ==0 -> "Buzz"
    else -> "$i"
}

fun main(args: Array<String>) {
    for (i in 1..100)
        println(fizzBuzz(i))

    for (i in 100 downTo 1 step 2 )
//    for (i in 100..1 step 2 )
        println(fizzBuzz(i))

    val binaryReps = TreeMap<Char,String>();

    for(c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt());
        binaryReps[c] = binary;
    }

    for((letter,binary) in binaryReps) {
        println("$letter = $binary");
    }

    val list = arrayListOf("10","11","1001");
    for((index,element) in list.withIndex()) {
        println("$index: $element")
    }

    fun isLetter(c:Char) = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotDigit(c:Char) = c in '0'..'9'
    println(isLetter('q'))
    println(isNotDigit('x'))

    println("Kotlin" in "Java".."Scala") //true
    //等价于
    println("Kotlin" > "Java" && "Kotlin" < "Scala") //true

    println("Kotlin" in setOf("Java","Scala")) //false
}