package OO

interface HouseFactory{
    fun createHouse(): House
}

class House( val numberOfROoms: Int, val price: Double) {
    companion object : HouseFactory {
        val HOUSES_fOR_SALE = 10
        fun getNormalHouse() = House( 6, 199_999.0)
        fun getLuxuryHouse() = House( 23, 2_199_999.0)
        override fun createHouse(): House {
            return getNormalHouse()
        }
    }
}

fun main(args: Array<String>) {
    val normalHouse = House.getNormalHouse()
}