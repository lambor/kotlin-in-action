package ch05

/**
 * Created by lambor on 17-5-26.
 * Functional APIs for collections
 */


fun main(args: Array<String>) {
    val list = listOf(1,2,3,4)
    list.filter { it % 2 == 0 }

    val people = listOf(Person("Alice",29),Person("Bob",31))
    people.filter { it.age>30 }

    people.map { it.name }
    people.map(Person::name)

    people.filter { it.age>30 }.map { it.name }
    people.filter{it.age == people.maxBy { it.age }?.age}

    val canBeInClub27 = {p:Person -> p.age <= 27}
    println(people.all(canBeInClub27))
    println(people.any(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.find ( canBeInClub27 ))

    val people2 = listOf(Person("Alice",31),Person("Bob",29),Person("Carol",31))
    println(people.groupBy { it.age })

    val liststr = listOf("a","aba","b")
    println(liststr.groupBy(String::first))

    class Book(val title:String,val author:Set<String>)
    val books = listOf<Book>()
    books.flatMap { it.author }

    println(liststr.flatMap { it.toList() })
}