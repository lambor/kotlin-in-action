package ch11

import com.sun.xml.internal.ws.util.StringUtils
import java.io.File

/**
 * Created by lambor on 17-6-7.
 * From APIs to DSLs
 */

fun main(args: Array<String>) {
    StringUtils.capitalize("123")
    "123".capitalize()

    1.to("one")
    1 to "one"

    val set:MutableSet<Int> = hashSetOf(1,2,3)
    set.add(4)
    set += 4

    val map = mapOf("key" to 123)
    map.get("key")
    map["key"]

    val file = File("/etc/hosts");
    file.useLines{
        it->println(it)
    }
    file.useLines {
        println(it)
    }

    val sb = StringBuilder()
    sb.append("yes")
    sb.append("no")

    with(sb) {
        append("yes")
        append("no")
    }
}
