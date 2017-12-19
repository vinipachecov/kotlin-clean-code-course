package functional

import java.io.FileReader

fun main(args: Array<String>) {

//    we can use "Use" with all classes that implements closeable
//    help to not forget to close connections, sockets, databases, RMIs, etc...
    FileReader("mayexist.txt").use {
//        perform some operations of file reader
        val str = it.readText()
        println(str)

    }
}