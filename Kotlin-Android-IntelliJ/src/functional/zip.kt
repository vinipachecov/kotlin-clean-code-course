package functional

fun main(args: Array<String>) {
    println("zip function! :)")

    val list = listOf("HI", "there", "kotlin", "fans")

    val containsT= listOf(false,true,true,false)

    val zipped: List<Pair<String, Boolean>> = list.zip(containsT)

    println("Result of list.zip =  " + list.zip(containsT))

    val mapping = list.zip(list.map {it.contains("t")})

    println(zipped)
    println(mapping)


}