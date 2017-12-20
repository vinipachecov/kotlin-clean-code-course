package com.vinicius.habittrainer.db

import android.provider.BaseColumns

/**
 * Created by vinicius on 12/20/17.
 */

val DATABASE_NAME = "habittrainer.db"
val DATABASE_VERSION = 10

object HabitEntry : BaseColumns {
    val TABLE_NAME = "habit"
    val ID = "id"
    val TITLE_COL = "title"
    val DESCR_COL = "description"
    val IMAGE_COL = "image"
}

