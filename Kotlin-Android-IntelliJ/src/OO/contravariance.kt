package OO


//producers
class Source<out T>(val t: T) {

    fun produceT():T {
        return t;
    }
}


//consumer
// takes parameters of type T and use their values
// never return a value
class Sink<in T> {
    fun consumeT(t: T){

    }
}

fun main(args: Array<String>) {
    val strSource: Source<String> =  Source("Producer")
    val anySource: Source<Any> = strSource
    anySource.produceT()

    val anySink: Sink<Any> = Sink()
    val strSInk: Sink<String> = anySink
    strSInk.consumeT(("COnsumer"))

}