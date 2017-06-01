package ch07

/**
 * Created by dcnh on 17-5-31.
 * Destructuring declarations and component functions
 */

class Point3(val x:Int,val y:Int)

operator fun Point3.component1():Int = x;
operator fun Point3.component2():Int = y;

fun main(args: Array<String>) {
    val p1 = Point(1,2)
    val (x,y) = p1;

    val p2 = Point3(1,2)
    val (x2,y2) = p2
}