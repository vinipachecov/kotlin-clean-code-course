package OO

open class Being
open class Person: Being()
class Student : Person()

fun main(args: Array<String>) {
    val people: MutableList<Person> = mutableListOf(Person(), Person())
    people.add(Student())

//    covariance
    val p: Person = Student( )


//    read-only collections are covariant
    val students: List<Person> = listOf<Student>()

    val students2: MutableList<Person> = mutableListOf<Person>()

//    kotlin timeseries

    val events: Timeline<Person> = timelineOf<Person>()

    val students3: List<Student> = listOf(Student(), Student())

//    another use of covariance
    events.addAll(students3)




}