package ch07

/**
 * Created by dcnh on 17-5-31.
 * Accessing elements by index
 */

operator fun Point.get(index:Int) : Int = when(index) {
    0->x
    1->y
    else->throw IndexOutOfBoundsException("Invalid coordinate $index")
}

operator fun Point.set(index:Int,value:Int) : Unit = when(index) {
    0->x = value
    1->y = value
    else->throw IndexOutOfBoundsException("Invalid coordinate $index")
}

operator fun Point.set(index1:Int,index2:Int,value:Int) : Unit {
    x = value
    y = value
}

data class Rectangle(val upperLeft:Point,val lowerRight:Point)

operator fun Rectangle.contains(point:Point):Boolean = point.x>upperLeft.x&&point.y<upperLeft.y&&point.x<lowerRight.x&&point.y>lowerRight.y

operator fun ClosedRange<Point2>.iterator():Iterator<Point2> = object : Iterator<Point2> {

    var current = start

    override fun hasNext(): Boolean {
        return current<=endInclusive
    }

    override fun next(): Point2 {
        return current.apply { current = next() }
    }

}

fun Point2.next():Point2{
    return Point2(x+1,y)
}

fun main(args: Array<String>) {
    val p1 = Point(1,2)
    println(p1[0])
    p1[1] = 10
    println(p1)

    p1[0,1] = 20
    println(p1)

    val rect = Rectangle(Point(10,20),Point(30,10))

    println(Point(15,15) in rect)

    //because Point2 implements Comparable interface
    println(Point2(10,15) in Point2(0,0)..Point2(10,16))

    for(point in Point2(0,0)..Point2(10,16)) {
        println(point)
    }
}
