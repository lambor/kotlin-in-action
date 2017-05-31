package ch06


/**
 * Created by lambor on 17-5-26.
 * Nullability
 */

fun strLenSafe(s:String?):Int = if(s!=null) s.length else 0

fun printAllCaps(s:String?) {
    val allCaps:String? = s?.toUpperCase()
    println(allCaps)
}

class Employee(val name:String,val manager:Employee?)

fun managerName(employee:Employee):String? = employee.manager?.name

fun foo(s:String?) {
    val t:String = s?:""
}

fun strLenSafe2(s:String?):Int= s?.length?:0

data class Address(val country:String,val city:String,val streetAddress:String,val zipCode:String)
data class Company(val address:Address?)
class Person(val company:Company?) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person?:return false;
        return company?.equals(otherPerson.company)?:false;
    }
}

fun Person.countryName():String =
    company?.address?.country?:"Unkown"

fun printShippingLabel(person:Person) {
    val address = person.company?.address?:throw IllegalArgumentException("No Address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

class MyService {
    fun performAction():String = "foo"
}

class MyTest {
    private lateinit var myService:MyService;

    fun setUp() {
        myService = MyService()
    }

    fun testAction() {
        myService.performAction()
    }
}

fun main(args: Array<String>) {
    printAllCaps("abc")
    printAllCaps(null)

    val ceo = Employee("Da Boss",null)
    val developer = Employee("Bob Smith",ceo)
    println(managerName(developer))
    println(managerName(ceo))

    println("person's country name: ${Person(null).countryName()}")
//    printShippingLabel(Person(Company(null)))
    printShippingLabel(Person(Company(Address("test","test","test","test"))))

    println(Person(Company(Address("test","test","test","test"))) == Person(Company(Address("test","test","test","test"))))

    val Null:Any? = null
//    println(Null!!.toString())
    Null?.let { println("Null is $it") }

    val str:String? = " "
    println(""" "${str}" is blank: ${str.isNullOrBlank()} """)
    println(""" "${str}" is empty: ${str.isNullOrEmpty()} """)
}