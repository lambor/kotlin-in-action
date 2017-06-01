package ch07

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by dcnh on 17-5-31.
 * Reusing property accessor logic: delegated properties
 */
class Foo {
    var p:String = ""
    set(value) {
        field = value
    }
    get() {return field}

    var p1:String by Delegate()

    private var _emails:List<String>? = null
    val emails:List<String>
    get() {
        if(_emails == null)
            _emails = arrayListOf()
        return _emails!!
    }
    val emails2 by lazy { arrayListOf<String>() }
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}

//7.5.3

data class PropertyEvent(val propertyName:String,val oldValue:Any,val newValue:Any)

class PropertyChangeListener(val listener:((PropertyEvent)->Unit))

class PropertyChangeSupport() {
    val listeners = arrayListOf<PropertyChangeListener>()

    fun addPropertyChangeListener(listener:PropertyChangeListener) {
        listeners.add(listener)
    }

    fun removePropertyChangeListen(listener:PropertyChangeListener) {
        listeners.remove(listener)
    }
}

fun PropertyChangeSupport.firePropertyChange(propertyName:String,oldValue:Any,newValue:Any) {
    listeners.forEach { it.listener.invoke(PropertyEvent(propertyName,oldValue,newValue)) }
}
//end of 7.5.3

class Foo2 (val name:String, age:Int,salary:Int){
    private val observer = {
        prop:KProperty<*>,oldValue:Int,newValue:Int ->
        println("prop.name=${prop.name}, oldValue=${oldValue}, newValue=${newValue}")
    }
    var age:Int by Delegates.observable(age,observer)
    var salary:Int by Delegates.observable(salary,observer)
}

class Person {
    private val _attributes = hashMapOf<String,String>()

    fun setAttribute(attrName:String,value:String) {
        _attributes[attrName] = value
    }

    val name:String by _attributes
}


fun main(args: Array<String>) {
    val foo = Foo()
    foo.p = "123"
    println(foo.p)

    println(foo.p1)

    val foo2 = Foo2("test",10,10)
    foo2.age = 20
    println(foo2.age)

    val person = Person()
    println(person.name) //NoSuchElementException
}