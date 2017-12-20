package OO

class Country(val name: String, val areaSqKm: Int) {

    constructor(name: String) : this(name, 0){
        println("Constructor Called")

    }

    fun print() = "$name , $areaSqKm km2"

}

fun main(args: Array<String>) {
    val brasil = Country("Brasil", 42_000_000)

    println(brasil.name)
    println(brasil.areaSqKm)

    println(brasil.print())

    val spain = Country("Spain")

    println(spain.print())
}