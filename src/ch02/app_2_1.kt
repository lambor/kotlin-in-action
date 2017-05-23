package ch02

/**
 * Created by lambor on 17-5-23.
 * functions and variables
 */
fun main(args: Array<String>) {
    println("Hello, world!")
    println(max(1,2));
    println(min(1,2));

    val question = "The Ultimate Question of Life, the Universe, and Everything"
    //val answer:Int = 42;
    //val answer:Int; answer = 42;
    val answer = 42;
    //err: answer = 52;

    println("Hello, ${if(args.size > 0) args[0] else "someone"}")
}

fun max(a:Int,b:Int) :Int {
    return if(a>b) a else b;
}

fun min(a:Int,b:Int) = if(a<b) a else b;