package OO

import com.sun.org.apache.xpath.internal.operations.Bool

class Robot(val name:String){

    fun greetHuman(){
        println("Hello, my name is $name")
    }

    fun knowItsName(): Boolean = name.isNotBlank()
}

fun main(args: Array<String>) {
    val fightRobot = Robot("Baymax")

    if(fightRobot.knowItsName()){
        fightRobot.greetHuman()
    }

}