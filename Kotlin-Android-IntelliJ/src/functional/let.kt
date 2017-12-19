package functional

import java.io.File

fun main(args: Array<String>) {

//    let(

// using for scoping
    File("example.txt").bufferedReader().let {
        if( it.ready()){
            println(it.readLine())
        }
    }

//    reader should no t be visible

//  working with nullables
    val str: String? = "Kotlin for Android"
    str?.let {
        if(str.isNotEmpty()){
            str.toLowerCase()
        }
    }
}