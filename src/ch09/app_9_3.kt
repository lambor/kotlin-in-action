package ch09

import java.util.*

/**
 * Created by lambor on 17-6-2.
 * Variance: generics and subtyping
 */

interface Producer<out T> {
    fun produce():T
}

interface Producer2<T> {
    fun produce():T
}

interface Consumer<in T> {
    fun consume(value:T)
}

//java:
//invokeNumberProducer(Producer<? extends Number> producer)
//下面两种都可以
fun invokeNumberProducer(producer: Producer<Number>) = producer.produce()
fun invokeNumberProducer2(producer: Producer2<out Number>) = producer.produce()

//java:
//invokeIntConsumer(Consumer<? super Int> consumer)
fun invokeIntConsumer(consumer:Consumer<Int>) {
    consumer.consume(1)
}


fun projectMutableListAdd(list:MutableList<out Int>) {
//    list.add(2)
}

fun <T> copyData(source:MutableList<out T>,destination:MutableList<T>) {
    for(item in source) {
        destination.add(item)
    }
}

interface FieldValidate<in T> {
    fun validate(input:T):Boolean
}

object DefaultStringValidator:FieldValidate<String> {
    override fun validate(input: String): Boolean = input.isNotEmpty()

}

object DefaultIntValidator:FieldValidate<Int> {
    override fun validate(input: Int): Boolean = input > 0
}

fun main(args: Array<String>) {
    invokeNumberProducer(object:Producer<Int> {
        override fun produce(): Int {
            return 1
        }
    })

    invokeIntConsumer(object :Consumer<Number>{
        override fun consume(value: Number) {
            throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    })

    invokeNumberProducer2(object:Producer2<Int> {
        override fun produce(): Int {
            return 1
        }
    })


    //9.3.6
    //Star projection: using * instead of a type parameter
    //I think kotlin: List<*> = java: List raw type
    val list:MutableList<Any?> = mutableListOf('a',1,"qwe")
    val chars = mutableListOf('a','b','c')

    val unknownElements:()->MutableList<*> = {
        if (Random().nextBoolean()) list else chars
    }

//    unknownElements().add('a') //not allowed
    val charElements = unknownElements as? MutableList<Char>?:throw ClassCastException()
    charElements.add('a')

    val validators = mutableMapOf<kotlin.reflect.KClass<*>,FieldValidate<*>>(Int::class to DefaultIntValidator,String::class to DefaultStringValidator);
//    validators.get(String::class)!!.validate("") //not allowed
}