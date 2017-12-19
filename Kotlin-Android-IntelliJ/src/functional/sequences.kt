package functional

import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val verLongLIst = (1..99999L).toList()


//    using function chaining

    var sum = 0L
    var lazySum = 0L


    val msNOnLazy = measureTimeMillis {
        sum = verLongLIst.filter { it > 50 }
                .map { it * 2 }
                .map { it / 3 }
                .map { it + 17 }
                .take(10000)
                .sum()
    }

    val msLazy = measureTimeMillis {
        lazySum = verLongLIst
                .asSequence()
                .filter { it > 50 }
                .map { it * 2 }
                .map { it / 3 }
                .map { it + 17 }
                .take(10000)
                .sum()
    }

    println("Non Lazy = $msNOnLazy ms, Result: $sum" )
    println("Lazy = $msLazy, Result: $lazySum" )

// easy way to generate a sequence
//    val sum2 = verLongLIst.asSequence()
//            .filter { it > 50 }
//            .map { it * 2 }
//            .take(1000)
//            .sum()
//
//    println(sum)
//    println(sum2)

////    using sequences
//
//    val seq = generateSequence(1, { it + 1})
//
//    println(seq.take(5000).toList())
}