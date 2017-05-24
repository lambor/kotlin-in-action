package ch03

/**
 * Created by lambor on 17-5-24.
 * Working with collections: varargs, infix calls, and library support
 */

fun <T> printAll(vararg elements: T) {
//    for(i in elements.asList()) {
//        println(i)
//    }
    for (i in 0 until elements.size) {
        println(elements[i])
    }
}

infix fun Any.equal(other:Any) = equals(other)


fun main(args: Array<String>) {
    printAll(1, 2, 2)
    println("A" equal "b")
    println("A" equal "a".toUpperCase())

    val pair:Pair<String,Int> = "1" to 1;
}