package ch09

/**
 * Created by lambor on 17-6-2.
 * Generic type parameters
 */

val authors = listOf("Dmitry","Svetlana")

val readers : MutableList<String> = mutableListOf()
val readers2 = mutableListOf<String>()

val lettters = ('a'..'z').toList()

//class inner generic property is not allowed
//extension generic property is allowed
val <T> List<T>.penultimate:T
get() = this[size-2]

fun <T : Number> oneHalf(value:T) : Double =
        value.toDouble()/2.0

fun <T : Comparable<T>> max(a:T,b:T):T {
    return if(a>b) a else  b
}

fun <T> ensureTrailingPeriod(seq:T) where T:CharSequence,T:Appendable {
    if(!seq.endsWith('.'))
        seq.append('.')
}

class Processor<T> {
    fun process(value:T) {
        value?.hashCode()
    }
}

class Processor2<T:Any> {
    fun process(value:T) {
        value.hashCode()
    }
}

fun main(args: Array<String>) {
    println(lettters.slice(0..2))
    println(listOf(1,2,3,4).penultimate)

    println(oneHalf(3))

    max("kotlin","java")

    val sb = StringBuilder("Hello World")
    ensureTrailingPeriod(sb)
    println(sb)

    val nullableStringProcessor = Processor<String?>()
    nullableStringProcessor.process(null)


}