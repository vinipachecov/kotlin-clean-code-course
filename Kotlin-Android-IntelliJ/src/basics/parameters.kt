package basics

import java.io.File.separator

fun main(args: Array<String>){
    val together = concat(separator = " : ", texts = listOf("Kotlin", "Java", "Scala"))
    println(together)
}

fun concat(texts: List<String>, separator: String = ", ") = texts.joinToString(separator)