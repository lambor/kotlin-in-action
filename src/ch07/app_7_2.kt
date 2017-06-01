package ch07

import kotlin.comparisons.compareValuesBy

/**
 * Created by dcnh on 17-5-31.
 * Overloading comparison operators
 */

data class Point2(var x:Int,var y:Int) : Comparable<Point2> {
    override fun compareTo(other: Point2): Int {
        return compareValuesBy(this,other,Point2::x,Point2::y)
    }

    override fun equals(other: Any?): Boolean {
        if(other === this) return true
        if(other !is Point2) return false
        return other.x == x && other.y == y
    }
}

fun main(args: Array<String>) {
    val p1 = Point2(1,2)
    val p2 = Point2(1,2)
    println(p1==p2)

    val p3 = Point2(2,1)
    val p4 = Point2(1,3)
    println(p3>p1)
    println(p4>p1)
}