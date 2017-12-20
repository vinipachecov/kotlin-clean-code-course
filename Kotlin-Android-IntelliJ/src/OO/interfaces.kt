package OO

interface  Drivable {
    fun drive(){
        println("Driving")
    }
}

class Bicycle : Drivable {
    override fun drive() {
        println("driving bicycle")
    }
    fun a() = 1
}

class Boat : Drivable{
    override fun drive() {
        println("Driving a boat :)")
    }
}

fun main(args: Array<String>) {

    val drivable: Drivable = Bicycle()
    drivable.drive()


    val bike = Bicycle()
    val boat = Boat()

    bike.drive()
    boat.drive()
}