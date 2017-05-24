package ch03

/**
 * Created by lambor on 17-5-24.
 * Adding methods to other people’s classes: extension functions
 * and properties
 */

fun String.lastChar():Char = this.get(this.length-1)

fun <T> Collection<T>.joinToString2(separator:String=", ",prefix:String="",suffix:String=""):String {
    val result = StringBuffer(prefix);
    for((index,element) in this.withIndex()) {
        if(index > 0)
            result.append(separator)
        result.append(element)
    }
    return result.append(suffix).toString()
}

open class View() {
    open fun click() = "I am a View"
}

class Button:View() {
    override fun click(): String = "I am a Button"
}

fun View.showOff() = println(this.click())

var StringBuffer.lastChar:Char
    get() = get(length-1)
    set(value) {
        this.setCharAt(length-1,value)
    }

fun main(args: Array<String>) {
    println("Kotlin".lastChar())
    println(listOf(1,2,3,4).joinToString2())

    val button = Button();
    button.showOff()

    val sb = StringBuffer("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}
