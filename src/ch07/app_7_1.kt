package ch07

/**
 * Created by dcnh on 17-5-31.
 * Overloading arithmetic operators
 */

data class Point(var x:Int,var y:Int) {
    operator fun plus(other:Point) : Point {
        return Point(x+other.x,y+other.y)
    }

    operator fun plusAssign(other:Point) {
        x+=other.x
        y+=other.y
    }
}

operator fun Point.times(scale:Double) : Point {
    return Point((x*scale).toInt(), (y*scale).toInt())
}

operator fun Char.times(times:Int) : String = toString().repeat(times)


operator fun Point.unaryMinus() : Point {
    return Point(-x,-y)
}

fun main(args: Array<String>) {
    val p1 = Point(10,20)
    val p2 = Point(30,40)
    println(p1 + p2)

    println((p1+p2)*10.0)

    println('A'*10)

    val list = arrayListOf<Int>()
    val list1 = list;
    list += 2
    println(list)
    println(list1 == list)

    val list2 = list + 1
    println(list2)
    println(list)
    println(list == list2)

    p1+=p2;
    println(p1)

    println(-p1)
}