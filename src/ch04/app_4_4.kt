package ch04

import ch02.Person
import java.util.*

/**
 * Created by dcnh on 17-5-25.
 * Declaring a class and creating an instance,combined,with the object keyword
 */

object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for(person in allEmployees) {}
    }
}

data class Person(val name:String) {
    companion object NameComparator : Comparator<ch04.Person> {
        override fun compare(p0: ch04.Person?, p1: ch04.Person?): Int = p0?.name.let{""}.compareTo(p1?.name.let{""})
    }
}

class Employee private constructor(val name:String) {
    companion object Factory {
        fun create(name:String) = Employee(name)
    }

    //not static
    fun create2(name:String) = Employee(name);
}

fun Employee.Factory.say() {
    println("say something")
}

interface CheckListener {
    fun oncheck()
}

class CheckView {
    var listener:CheckListener? = null
    set(value) {
        listener = value
    }
}

//nested object in class implements static usage of java
fun main(args: Array<String>) {
    val persons = listOf(Person("Bob"),Person("Alice"));
    println(persons.sortedWith(ch04.Person.NameComparator))
    println(persons.sortedWith(ch04.Person))// only sugar

    Employee.say() //=> Employee.Factory.say()
//    println(persons.sortedWith(Person("fuck"))) //error

    val view = CheckView()
    var count = 0;
    view.listener = object :CheckListener {
        override fun oncheck() {
            count++
        }
    }
}
