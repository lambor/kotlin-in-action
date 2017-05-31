package ch06

import java.io.BufferedReader
import java.io.StringReader
import java.util.*

/**
 * Created by dcnh on 17-5-27.
 * Collections and arrays
 */

fun readNumbers(reader: BufferedReader) : List<Int?> {
    val result = ArrayList<Int?>()
    for(line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        } catch (e:NumberFormatException) {
            result.add(null)
        }
    }
    return result;
}

fun addValidNumbers(numbers:List<Int?>) : Int{
    return numbers.filterNotNull().sum();
}

fun printInUpperCase(source:List<String>) {
    println(CollectionUtils.uppercaseAll(source))
    println(source.first())
}
fun main(args: Array<String>) {
    println(readNumbers(BufferedReader(StringReader("123\nfuck\n33"))))
    println(addValidNumbers(listOf(1,2,null,3,3,null)))

    val source1:MutableCollection<Int> = arrayListOf(1,2,3)
    val source2:Collection<Int> = arrayListOf(1,2,3)
//    val source3:MutableCollection<Int> = listOf(1,2,3) //err
    val source4:Collection<Int> = listOf(1,2,3)

    printInUpperCase(listOf("a","b","c"))


}
