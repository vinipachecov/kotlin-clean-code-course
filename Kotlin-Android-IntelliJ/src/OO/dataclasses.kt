package OO

//generate hashcode(), equals(), copy(), desctructuring operator
data class Address(val street: String, val number: Int, val postCode: String, val city: String)

fun main(args: Array<String>) {
    val residence = Address("Main Street", 4, "1235", "Santa Maria")
    val residence2 = Address("Avenida Ipiranga", 4, "1235", "Porto Alegre")

    print(residence)

    println(residence === residence2)
    println(residence == residence2)

    val neighbor = residence.copy(number = 55)
    println(neighbor)

    residence.component1()

    val(street, number, postCode, city ) = residence
    println("$street $number, $postCode $city")
}