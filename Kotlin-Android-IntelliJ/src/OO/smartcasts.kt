package OO

fun Bicycle.replaceWheel(){
    println("replacing wheel...")
}

fun Boat.startEngine():Boolean {
    println("Starting engine...")
    return true
}

fun main(args: Array<String>) {

    val vehicle: Drivable = Bicycle()

//    how to diferentiate from different types

    vehicle.drive()
    if (vehicle is Bicycle){
        vehicle.replaceWheel()
    } else if (vehicle is Boat){
        vehicle.startEngine()
    }

    if( vehicle is Boat && vehicle.startEngine()){
        println("vehicle started engine :)")
    }

    if( vehicle !is Boat || vehicle.startEngine()) {
        println("this should not be a boat")
    }

    if( vehicle !is Bicycle){
        println("not a bicycle")
        return
    }

}