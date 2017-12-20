package com.vinicius.habittrainer

/**
 * Created by vinicius on 12/20/17.
 */
data class Habit(val title: String, val desciption: String, val image: Int)

fun getSampleHabits(): List<Habit> {
    return listOf(
            Habit("Go for a walk",
                    "A nice walk in the sun gets you ready for the day ahead",
                    R.drawable.walk),
            Habit("Drink some Water",
                    "It's always good to drink good glass of water",
                    R.drawable.water)
    )
}