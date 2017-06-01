@file:JvmName("DemoUtils")
package ch08

/**
 * Created by lambor on 17-6-1.
 * Declaring higher-order functions
 */

val sum = {x:Int,y:Int->x+y}
val action = {println(42)}

fun twoAndThree(operation:(Int,Int)->Int) {
    val result = operation.invoke(2,3)
    println("The result is $result")
}

fun String.filter(predicate:(Char)->Boolean) : String {
    val sb = StringBuilder();
    for(index in 0..this.length-1) {
        val element = get(index)
        if(predicate.invoke(element)) sb.append(element)
    }
    return sb.toString()
}

fun processTheAnswer(f:((Int)->Int)?) {
    f?.invoke(42)?.let { println(it) }
}


data class Person(
        val firstName:String,
        val lastName:String,
        val phoneNumber:String?
)

class ContactListFilters {
    var prefix:String = ""

    var onlyWithPhoneNumber:Boolean = false

    fun getPredicate():(Person)->Boolean {
        val startsWithPrefix = {p:Person->p.firstName.startsWith(prefix)}
        if(!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return {startsWithPrefix(it) && it.phoneNumber!=null};
    }
}

data class SiteVisit(val path:String,
                     val duration:Double,
                     val os:OS)

enum class OS {WINDOWS,LINUX,MAC,IOS,ANDROID}

val log = listOf(
        SiteVisit("/",34.0,OS.WINDOWS),
        SiteVisit("/",22.0,OS.MAC),
        SiteVisit("/login",12.0,OS.WINDOWS),
        SiteVisit("/signup",8.0,OS.IOS),
        SiteVisit("/",16.3,OS.ANDROID)
)

fun List<SiteVisit>.averageDurationFor(predicate:(SiteVisit)->Boolean) = filter(predicate).map(SiteVisit::duration).average()

fun main(args: Array<String>) {
    println("ab1c".filter { it in 'a'..'z' })

    val contacts = listOf(Person("Dmitry","Jemerov","123-4567"),
            Person("Svetlana","Isakova",null))
    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactListFilters.getPredicate()))

    val averageWindowsDuration = log.filter { it.os == OS.WINDOWS }.map (SiteVisit::duration).average()
    println(averageWindowsDuration)

    println(log.averageDurationFor { it.os in listOf(OS.ANDROID,OS.IOS) })
    println(log.averageDurationFor { it.os==OS.IOS && it.path == "/signup" })
}