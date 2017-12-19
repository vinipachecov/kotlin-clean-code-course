package basics

fun main(args: Array<String>) {

    println("take and drop functions")

//    val list = (1..1000).toList()

    val list = generateSequence (0){
        println("Calculating ${it + 10}")
        it + 10}

    val first10 = list.take(10).toList()
    val withoutFirs900 = list.drop(900)

    val first20 = list.take(20).toList()

    println(first10)
    println(first20)

}