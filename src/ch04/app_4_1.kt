package ch04

import java.io.Serializable

/**
 * Created by lambor on 17-5-24.
 * Defining class hierarchies
 */

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable")
}

interface Focusable {
    fun setFocus(b:Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focussable!")
}

class Button:Clickable, Focusable {
    override fun showOff() = super<Clickable>.showOff()

    override fun click() = println("I'm clicked")
}

open class RichButton : Clickable {

    fun disable() {}

    open fun animate() {}

    final override fun click() {
        println("rich button clicked")
    }

}


internal open class TalkativeButton: Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

//fun TalkativeButton.giveSpeech() { //'public' member exposes its 'internal' receiver type TalkativeButton
//    yell() //cannot access 'yell': it is 'protected' in 'TalkativeButton'
//    whisper() //cannot access 'whisper': it is 'private' in 'TalkativeButton'
//}

interface State: Serializable

interface View {
    fun getCurrentState() : State
    fun restoreState(state:State) {}
}

class ButtonView:View {
    override fun getCurrentState(): State {
//        return ButtonState()
        return ButtonState2()
    }

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    class ButtonState : State //kotlin not store outter class's 'this' reference

    inner class ButtonState2 : State {
        fun getOuterReference() : ButtonView = this@ButtonView
    }
}

sealed class Expr {
    class Num(val value:Int) : Expr()
    class Sum(val left:Num,val right:Num) : Expr()
}

fun eval(e:Expr):Int = when(e) {
    is Expr.Num->e.value
    is Expr.Sum-> eval(e.left) + eval(e.right)
}


fun main(args: Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()

    val buttonView = ButtonView()
    val state = buttonView.getCurrentState();

    println(eval(Expr.Sum(Expr.Num(1),Expr.Num(2))))
}