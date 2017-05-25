package ch04

/**
 * Created by lambor on 17-5-24.
 * Visibility modifiers: public by default
 */

//class User(val nickname:String)
open class User constructor(_nickname:String,val isSubscribed:Boolean = true) {
    val nickname:String;
    init {
        nickname = _nickname
    }
}

class AdvanceUser(_nickname: String,val fuck:Boolean) : User(_nickname,false)

class Scretive private constructor()

open class View2 {

    val value:String
    constructor(value:String) {
        this.value = value
    }

    constructor(value:String,attr:String):this(value) {

    }
}

interface User2 {
    val nickname:String
    val email:String
        get() = "hello@kotlin.com"
}

class PrivateUser(override val nickname:String):User2
class SubscribiingUser(email:String) : User2 {
    override val nickname: String
        get() = email.substringBefore('@')
}
class FacebookUser(val accountId:Int) : User2 {
    override val nickname = "hello"
}

class MyView2 : View2 {
    constructor(value:String):super(value)
    constructor(value:String,fucked:Boolean):this(value)
}