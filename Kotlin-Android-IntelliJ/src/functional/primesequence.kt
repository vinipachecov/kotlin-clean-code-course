package functional

//sieve of eratosthenes

//generate a sequece starting with 2

//get the next prime

//      check if element can be divisible by something

// return and get next number


fun main(args: Array<String>) {


    var possibliePrimesAfter2 = generateSequence(3) {it + 2 }
//    starts with 2
    val prime   = generateSequence (2 to possibliePrimesAfter2) {


//        our next prime number
        val p = it.second.first()

//        only elements not divisible by p (our next prime number) -- which is not prime
        val possiblePrimesAfterP = it.second.filter { it % p != 0 }

//        return the next element in the sequence
        p to possiblePrimesAfterP
    }.map { it.first}

    println(prime.take(10).toList())
}