package ch11

/**
 * Created by lambor on 17-6-7.
 * More flexible block nesting with the "invoke" convention
 */

class Greeter(val greeting:String)
{
    operator fun invoke(name:String) {
        println("$greeting, $name!")
    }
}

data class Issue(
        val id:String,val project:String,val type:String,
        val property:String,val description:String
)

class ImportantIssuePredicate(val project:String) : (Issue)->Boolean {
    override fun invoke(issue:Issue):Boolean {
        return issue.project == project && issue.isImportant()
    }

    private fun Issue.isImportant() : Boolean {
        return type == "Bug" && (property == "Major" || property == "Critical")
    }
}

fun main(args: Array<String>) {
    val bavarianGreeter = Greeter("Servus");
    bavarianGreeter("Dmitry")

    val i1 = Issue("IDEA-154446","IDEA","Bug","Major","Save settings failed")
    val i2 = Issue("KT-12183","Kotlin","Feature","Normal","Intention: covert serveral calls on the same receiver to apply/with")
    val predicate = ImportantIssuePredicate("IDEA")
}


