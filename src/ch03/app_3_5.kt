package ch03

/**
 * Created by lambor on 17-5-24.
 * Working with strings and regular expressions
 */
fun main(args: Array<String>) {
    println("12.345-6.A".split('.','-'))

    parsePathRegexp("""/home/lambor/hello.kt""")

    val kotlinLogo = """| //
                       .|//
                       .|/  \"""
    println(kotlinLogo.trimMargin("."))
}

fun parsePathRegexp(path:String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path);
    if(matchResult != null) {
        val (directory,filename,extension) = matchResult.destructured;
        println("Dir:$directory,name:$filename,ext:$extension")
    }
}
