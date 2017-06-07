package ch11

/**
 * Created by lambor on 17-6-7.
 * Building structed APIs: Lambdas with receiver in DSLs
 */

fun buildString(buildAction:StringBuilder.()->Unit):String =
    StringBuilder().apply {
        buildAction()
    }.toString()


open class TAG(val name:String) {
    val children = mutableListOf<TAG>()
    override fun toString(): String {
        return "<$name>${children.joinToString("","","")}</$name>"
    }
}

class Table : TAG("table") {
    fun tr(trblock:TR.()->Unit) :Table {
        children.add(TR().apply(trblock))
        return this;
    }
}

class TR:TAG("tr") {
    fun td(tdblock:TD.()->Unit) :TR {
        children.add(TD().apply(tdblock))
        return this
    }
}

class TD:TAG("td")

fun main(args: Array<String>) {
    val str = buildString {
        append("Hello, ")
        append("World!")
    }
    println(str)

    val table = Table().tr {
        td{
        }
        td{
        }
    }
    println(table)
}