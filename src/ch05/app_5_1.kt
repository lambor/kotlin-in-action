package ch05

import ch03.joinToString2


/**
 * Created by lambor on 17-5-26.
 * Lambda expressions and member references
 */

data class Person(val name:String,val age:Int)

fun <T> Collection<T>.joinToString3(separator:String,transform:((t:T)->String)):String {
    val result = StringBuffer();
    for(t in this) {
        result.append(separator)
        result.append(transform(t))
    }
    return result.substring(1)
}

fun printMessagesWithPrefix(messages:Collection<String>,prefix:String) {
    messages.forEach { println("$prefix $it") }
}

fun printProblemCounts(responses:Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if(it.startsWith("4"))
            clientErrors++
        else if(it.startsWith("5"))
            serverErrors++
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

class Test(val func1:(()->kotlin.Unit),val func2:(()->Int))

fun test():Test {
    var local = 0;
    val func1 = {local++;kotlin.Unit}
    val func2 = {local}
    return Test(func1,func2)
}

fun salute() = println("Salute!")

fun main(args: Array<String>) {
    val list = listOf(Person("Alice", 29), Person("Bob", 31))
    println(list.maxBy { it.age })
    println(list.maxBy(Person::age))

    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))

    ; //semicolon must exist!!!
    { println(42) }()

    println(list.maxBy({ p:Person->p.age }))
    println(list.maxBy() {p:Person->p.age})
    println(list.maxBy { p:Person->p.age })
    println(list.maxBy { it.age })
    println(list.maxBy (Person::age))

    println(list.joinToString3(",",{p->p.name}))

    val errors = listOf("403 Forbidden","404 Not Found")
    printMessagesWithPrefix(errors,"Error:")

    val test1 = test()
    test1.func1()
    test1.func1()
    test1.func1()
    println(test1.func2())

    run(::salute)
}


