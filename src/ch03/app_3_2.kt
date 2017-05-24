@file:JvmName("StringFunctions")
package ch03

/**
 * Created by lambor on 17-5-24.
 * Making functions easier to call
 */
@JvmOverloads
fun <T> joinToString(collection:Collection<T>,
                     separator:String=" ",
                     prefix:String=" ",
                     suffix:String=".") :String {
    val result = StringBuffer(prefix);
    for((index,element) in collection.withIndex()) {
        if(index > 0)
            result.append(separator)
        result.append(element)
    }
    return result.append(suffix).toString();
}

var opCount = 0;

fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    println("Operation performed $opCount times")
}

const val UNIX_LINE_SEPARATOR = "/n"

fun main(args: Array<String>) {
    val list = listOf(1,2,3)
    println(list)

    println(joinToString(list,";","(",")"))

}
