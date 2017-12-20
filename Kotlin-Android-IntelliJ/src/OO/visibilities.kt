package OO

// private = save as in java
//protected -same as in java
// internal - visiblie inside the same module
//public - accesible anywhere - same as in java - default

class Car(val brand: String, private val model: String){
    internal fun tellmeYourModel() = println("${this.model}")
}

fun main(args: Array<String>) {
    val car = Car("Chev", "Captiva")
    car.tellmeYourModel()
}