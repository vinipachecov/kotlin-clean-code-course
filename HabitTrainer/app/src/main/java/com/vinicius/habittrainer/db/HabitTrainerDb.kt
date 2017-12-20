package com.vinicius.habittrainer.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.vinicius.habittrainer.Habit

/**
 * Created by vinicius on 12/20/17.
 */
class HabitTrainerDb (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){


    private val SQL_CREATE_ENTRIES = "CREATE TABLE ${HabitEntry.TABLE_NAME} (" +
            "${HabitEntry.ID} INTEGER PRIMARY KEY ," +
            "${HabitEntry.TITLE_COL} TEXT ," +
            "${HabitEntry.DESCR_COL} TEXT ," +
            "${HabitEntry.IMAGE_COL} BLOB " +
            ")"

    private  val SQL_DELETE_ENTRIES = "DROP TABLE IF EXITS ${HabitEntry.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    // when the database receives a upgrade in its version
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

}