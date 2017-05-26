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


fun main(args: Array<String>) {
    printAllCaps("abc")
    printAllCaps(null)

    val ceo = Employee("Da Boss",null)
    val developer = Employee("Bob Smith",ceo)
    println(managerName(developer))
    println(managerName(ceo))
}