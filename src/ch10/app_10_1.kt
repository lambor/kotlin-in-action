package ch10

/**
 * Created by lambor on 17-6-2.
 * Declaring and applying annotations
 */

@Deprecated(
        "Use testNew() instead.",
        ReplaceWith("testNew()")
)
fun testOld() {
    println("old test")
}

fun testNew() {
    println("new test")
}

fun main(args: Array<String>) {
    testOld()
}