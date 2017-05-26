package ch05

/**
 * Created by lambor on 17-5-26.
 * Lambdas with receivers: with and apply
 */

fun alphabet() : String {
    val result = StringBuilder()
    for(letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabet2() : String {
    return with(StringBuilder()) {
        for(letter in 'A'..'Z')
            append(letter)
        append("\nNow I know the alphabet!")
        toString()
    }
}

fun alphabet3() = StringBuilder().apply {
    for(letter in 'A'..'Z')
        append(letter)
    append("\nNow I know the alphabet!")
}.toString()

fun alphabet4() = buildString {
    for(letter in 'A'..'Z')
        append(letter)
    append("\nNow I know the alphabet!")
}

fun main(args: Array<String>) {
    println(alphabet())
    println(alphabet2())
    println(alphabet3())
    println(alphabet4())
}