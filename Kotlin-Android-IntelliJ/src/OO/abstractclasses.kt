package OO

abstract class Shape(val name: String) {
    abstract fun area():Double


}


class Circle(name: String, val radius: Double): Shape(name) {
    override fun area(): Double {
        return Math.PI * Math.pow(radius, 2.0)
    }
}

fun main(args: Array<String>) {
    val shape = Circle("Large circle", radius = 27.0)
    println("Area of the circle ${shape.area()}")
}
