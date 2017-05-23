package ch02

/**
 * Created by lambor on 17-5-23.
 * Classes and properties
 */

class Person(
        val name:String,
        var isMarried:Boolean
)

class Rectangle(var height:Int,var width:Int) {
    val isSquare:Boolean
    get() {
        return height==width;
    }
}

fun main(args: Array<String>) {
    val person = Person("Lambor",false);
    println("name:"+person.name);
    println("isMarried:"+person.isMarried);
    println("God forces him marry some girl.")
    person.isMarried = true;
    println("now isMarried:" + person.isMarried);

    println(max(1,2))
}