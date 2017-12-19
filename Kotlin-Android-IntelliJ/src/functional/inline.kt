package functional

//fun modifiyString(str: String, operation: (String) -> String):String {
//    return operation(str)
//}

inline fun modifiyString(str: String, operation: (String) -> String):String {
    return operation(str)
}

fun main(args: Array<String>) {
    println(modifiyString("Kotlin is great!!!", {it.toUpperCase()}))
}