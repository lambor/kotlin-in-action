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

    override fun click() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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




fun main(args: Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}