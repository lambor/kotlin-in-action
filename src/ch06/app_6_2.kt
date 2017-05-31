package ch06

/**
 * Created by dcnh on 17-5-27.
 * Primitive and other basic types
 */
fun showProgress(progress:Int) {
    val percent = progress.coerceIn(0,100)
    println("We're ${percent}% done!")
}

data class Person2(val name:String,val age:Int?=null) {
    fun isOlderThan(other:Person2):Boolean? {
        return age?.let { age1->other.age?.let { age2-> age1>age2 } }
    }
}

interface Processor<T> {
    fun process():T
}

class NoResultProcessor:Processor<Unit> {
    override fun process() {
        println("no result override function")
    }
}

fun main(args: Array<String>) {
    showProgress(146)
    val person1 = Person2("1",null)
    val person2 = Person2("2",2)
    val person3 = Person2("3",null)
    val person4 = Person2("4",4)

    println(person1.isOlderThan(person2))
    println(person2.isOlderThan(person1))
    println(person1.isOlderThan(person3))
    println(person2.isOlderThan(person4))
    println(person4.isOlderThan(person2))

    println("abc".toByteArray().joinToString(separator = ","))

    val a:Byte = 1;
    val b:Long = 2;

    println("a+b=${a+b}")

    fun fail() : Nothing {
        throw Exception("fail")
    }

    val test:String?=null
    test?:fail()
}
