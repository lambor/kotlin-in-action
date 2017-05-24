package ch03

/**
 * Created by lambor on 17-5-24.
 * Making your code tidy: local functions and extensions
 */

class User(val id:Int, val name:String, val address:String)

fun User.validateBeforeSave() {
    fun validate(value:String,fileName:String) {
        if(value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fileName")
        }
    }
    validate(name,"Name")
    validate(address,"Address")
}

fun saveUser(user:User) {
    user.validateBeforeSave();

    println("after validate")
    println("save finish")
}