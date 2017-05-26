package ch04

import java.util.*

/**
 * Created by dcnh on 17-5-25.
 * Compiler-generated methods: data classes and class delegation
 */

class Client(val name:String,val postalCode:Int) {
    override fun toString() = "Client(name=$name,postalCode=$postalCode)"
    override fun equals(other: Any?) = other != null && other is Client && name == other.name && postalCode == other.postalCode
}

data class Client2(val name:String,val postalCode: Int)


//different from extend!!!
//don't care the implement of impl class. like does the addAll method invoke the add method
class CountingSet<T>(private val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {

    var objectsAdded = 0
    private set


    override fun add(element: T): Boolean {
        objectsAdded ++
        return innerSet.add(element);
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

fun main(args: Array<String>) {
    val client1 = Client("hello",1)
    val client2 = Client("hello",1)
    println("$client1 ${if (client1==client2) "==" else "!="} $client2")

    val client3 = Client2("hello2",2)
    val client4 = Client2("hello2",2)
    println(client3 == client4)

    val client2set = setOf(Client2("hello2",2))
    println(client3 in client2set)

    val set = CountingSet<Client>()
    set.add(client1)
    set.add(client2)
    println(set.objectsAdded)
    val client3_2 = client3.copy(name="new hello")
}


