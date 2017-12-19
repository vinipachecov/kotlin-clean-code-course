package basics

import java.io.IOException

fun main(args: Array<String>) {


//    remember that you can use try and other expressions to get their result
    val input = try {
        getExternalInput()
    }catch (e: IOException){
        e.printStackTrace()
        ""
    } finally {
        println("finished processing external input ")
    }
    println(input)



}

fun getExternalInput():String {
    throw IOException("Could not read external input")
}