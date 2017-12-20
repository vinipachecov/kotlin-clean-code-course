package OO

import java.util.*

val list: List<Int> = listOf(1,2,3)


class Timeline<E> {
    val date2Data: MutableMap<Date, E> = mutableMapOf()

    fun add(element: E){
        date2Data.put(Date(), element)
    }

    fun getLatest(): E {
        return date2Data.values.last()
    }

    fun addAll(elements: Collection<E>){
        elements.forEach {
            this.add(it)
        }
    }

}

fun <E>timelineOf(vararg elements: E) : Timeline<E>{
    val result = Timeline<E>()
    for( element in elements){
        result.add(element)
    }
    return result
}


fun main(args: Array<String>) {
    val tl = Timeline<Int>()
    tl.add(2)
    tl.add(23)
    tl.add(44)
    println(tl.getLatest())

    val tl2 = timelineOf(1,2,3)
    val tl3 = timelineOf("Kotlin", "Juice", "Go")
}