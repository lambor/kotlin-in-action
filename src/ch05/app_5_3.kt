package ch05

import java.io.File

/**
 * Created by lambor on 17-5-26.
 * Lazy collection operations: sequences
 */

fun main(args: Array<String>) {
    val seq = listOf(1,2,3,4).asSequence().map { println("map($it)"); it*it }
    .filter { print("filter($it)");it%2 == 0 }

    val list1 = seq.toList()
    println("list1 : $list1")
    val list2 = seq.toList()
    println("list2 : $list2")

    val naturalNumbers = generateSequence (0){ it+1 }
    val numbersTo100 = naturalNumbers.takeWhile { it<=100 }
    println(numbersTo100.sum())

    fun File.isInsideHidenDirectory() =
            generateSequence(this) { it.parentFile }.any { it.isHidden }

    val file = File("/Users/svtk/.HiddenDir/a.txt")
    println("${file.name} ${if(file.isInsideHidenDirectory())"is in" else "not in"} hidden directory.")

    val thread = Thread(){ println("123")}
    //java8:  new Thread(()->{println("123")})
    thread.start()

    val thread2 = Thread(object:Runnable {
        override fun run() {
            println("345")
        }
    })
    thread2.start()

    val runnable = Runnable {
        println("345")
    }
    Thread(runnable).start()
}
