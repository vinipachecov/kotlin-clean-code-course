package OO

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

object CountryFactory {
    val a = 4
    fun createCountry() = Country("Brasil", 0)
}

object defaultClickListener : MouseAdapter(){
    override fun mouseClicked(e: MouseEvent?) {
        println("Mouse Clicked :)")
    }
}


fun main(args: Array<String>) {
    CountryFactory.a
    CountryFactory.createCountry()
}