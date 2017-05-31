package ch06


/**
 * Created by lambor on 17-5-26.
 * Nullability
 */

fun strLenSafe(s:String?):Int = if(s!=null) s.length else 0

fun printAllCaps(s:String?) {
    val allCaps:String? = s?.toUpperCase()
    println(allCaps)
}

class Employee(val name:String,val manager:Employee?)

fun managerName(employee:Employee):String? = employee.manager?.name


fun foo(s:String?) = s?:"";

fun foo2(s:String?) = s?:throw NullPointerException()

class Person(val firstName:String,val lastName:String) {
    override fun equals(other: Any?): Boolean {
        return (other as? Person ?:return false).equal(this)
    }

    fun equal(person:Person) = person.firstName == firstName && person.lastName == lastName
}

fun main(args: Array<String>) {
    printAllCaps("abc")
    printAllCaps(null)

    val ceo = Employee("Da Boss",null)
    val developer = Employee("Bob Smith",ceo)
    println(managerName(developer))
    println(managerName(ceo))

    foo(null)
    foo("123")
//    foo2(null)
    foo2("123")

    val person1:Person? = Person("1","2")
    val person2:Person? = null
    println(person1 == person2)
}