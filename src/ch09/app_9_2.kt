package ch09

/**
 * Created by lambor on 17-6-2.
 * Generics at runtime:erased and reified type parameters
 */


//runtime generic type check
fun printSum(c:Collection<*>) {
    val list = c as? List<Int>?:throw IllegalArgumentException("List is expected")
    println(list.sum())
}

//compile time type check
fun printSum2(c:Collection<Int>) {
    val list = c as? List<Int> ?:throw IllegalArgumentException("List is expected")
    println(list.sum())
}

inline fun <reified T> isA(value:Any) = value is T

inline fun <reified T> Iterable<*>.filterIsInstance():List<T> {
    val dest = mutableListOf<T>()
    for(element in this) {
        if(element is T)
            dest.add(element)
    }
    return dest
}

fun <T> clazzFoo(clazz:Class<T>) {

}

inline fun <reified T:Any> invokeClazzFoo() {
    clazzFoo<T>(T::class.java)
}

fun main(args: Array<String>) {
    printSum(listOf(1,2,3,4))
//    printSum(setOf(1,2,3))
//    printSum(listOf("1","2","3","4"))

    println(isA<String>("abc")) //println("abc" is String)
    println(isA<String>(123)) //println(123 is String)

    val clazz:Class<String> = String::class.java
}

