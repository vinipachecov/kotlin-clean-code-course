package basics

import java.util.Random


val PI = 3.1415
// no class to create a function :)

fun randomIntegers():MutableList<Int>{
    var numbers =  mutableListOf<Int>()
    for(i in 0..100){
        numbers.add(Random().nextInt(100 - 0) + 1)
    }
    return numbers
}

fun main(args: Array<String>) {
    val list = listOf("KOtlin", "Android")
    print(list)
    print("Val of Pi is  $PI")

//    var rl = readLine()
//    if( rl != null){
//        print(rl)
//    }

    println(randomIntegers().toString())
}