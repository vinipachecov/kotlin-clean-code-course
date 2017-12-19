package functional

fun main(args: Array<String>) {
    val props = System.getProperties()

    with(props) {
        list(System.out)
        println(propertyNames().toList())
    }


//    props.list(System.out)
//    props.list()

}