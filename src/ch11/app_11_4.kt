package ch11

import com.sun.org.apache.xpath.internal.operations.Bool
import java.time.LocalDate
import java.time.Period

/**
 * Created by lambor on 17-6-7.
 * Kotlin DSLs in practice
 */

interface Matcher<T> {
    fun test(value:T)
}

class startsWith(val prefix:String):Matcher<String> {
    override fun test(value: String) {
        if(!value.startsWith(prefix))
            throw AssertionError("String $value does not start with $prefix")
    }
}

infix fun <T> T.should(matcher:Matcher<T>) = matcher.test(this)



object start

class StartWrapper(val str:String) {
    fun test(prefix:String) {
        if(!str.startsWith(prefix))
            throw AssertionError("String $str does not start with $prefix")
    }
}




infix fun String.should(x:start):StartWrapper = StartWrapper(this)

infix fun StartWrapper.with(prefix:String) = this.test(prefix)

val Int.days:Period
get() = Period.ofDays(this)

val Period.ago:LocalDate
get() = LocalDate.now() - this

val Period.fromNow:LocalDate
get() = LocalDate.now() + this

fun main(args: Array<String>) {
    "123" should startsWith("123")

//    "123" should start with "321"

    println(1.days.ago)
}