package ch08

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.Lock

/**
 * Created by dcnh on 17-6-1.
 * Inline functions:removing the overhead of lambdas
 */

inline fun <T> sychronized(lock: Lock,action:()->T):T {
    lock.lock()
    try {
        return action.invoke()
    }finally {
        lock.unlock()
    }
}


fun foo1(lock:Lock) {
    sychronized(lock) {
        println("this sychronized will be inline")
    }
}

fun foo2(lock:Lock,action:()->Unit) {
    sychronized(lock,action) //this sychronized can not be inline
}

inline fun foo(inlined:()->Unit,noinline notInlined:()->Unit) {}

fun readFirstLineFromFile(path:String):String {
    return BufferedReader(FileReader(path)).use {
        br->br.readLine()
    }
}

