package ch08

/**
 * Created by dcnh on 17-6-1.
 * Control flow in higher-order functions
 */

fun lookForAlice(people:List<Person>) {
    people.forEach {
        if(it.firstName == "Alice") {
            println("Found")
            return
        }
    }
    println("If found alice you will not see this")
}

fun lookForAlice1(people:List<Person>) {
    people.forEach {people->
        if(people.firstName == "Alice") {
            println("Found")
            return
        }
    }
    println("If found alice you will not see this")
}

fun lookForAlice2(people:List<Person>) {
    people.forEach {
        if(it.firstName == "Alice") {
            println("Found")
            return@forEach
        }
    }
    println("you will always see this")
}

fun lookForAlice3(people:List<Person>) {
    people.forEach (fun (people):Unit{
        if(people.firstName == "Alice") {
            println("Found")
            return
        }
    })

    println("you will always see this")
}

//forEach inline function
fun main(args: Array<String>) {
    val people = listOf<Person>(Person("A","B",null),Person("A","B",null),Person("Alice","B",null),Person("A","B",null))

    //forEach only three elements
    lookForAlice(people)
    lookForAlice1(people)

    //forEach all four elements
    lookForAlice2(people)
    lookForAlice3(people)
}


