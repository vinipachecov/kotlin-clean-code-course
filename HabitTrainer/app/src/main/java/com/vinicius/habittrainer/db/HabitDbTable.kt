package com.vinicius.habittrainer.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteQuery
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.vinicius.habittrainer.Habit
import com.vinicius.habittrainer.db.HabitEntry.DESCR_COL
import com.vinicius.habittrainer.db.HabitEntry.ID
import com.vinicius.habittrainer.db.HabitEntry.IMAGE_COL
import com.vinicius.habittrainer.db.HabitEntry.TABLE_NAME
import com.vinicius.habittrainer.db.HabitEntry.TITLE_COL
import java.io.ByteArrayOutputStream

/**
 * Created by vinicius on 12/20/17.
 */


class HabitDbTable(context: Context) {

    private val TAG = HabitTrainerDb::class.java.simpleName

    private val dbHelper = HabitTrainerDb(context)

    fun store(habit: Habit): Long {
        val db = dbHelper.writableDatabase

        val values = ContentValues()
        with(values) {
            put(HabitEntry.TITLE_COL, habit.title)
            put(HabitEntry.DESCR_COL, habit.desciption)
            put(HabitEntry.IMAGE_COL, toByteArray(habit.image))
        }


        val id: Long = db.transaction {
            insert(HabitEntry.TABLE_NAME, null, values)
        }

        Log.d(TAG, "store new habit to the DB $habit")

        return id
    }

    fun readAllHabits(): List<Habit> {

        val columns = arrayOf(ID, TITLE_COL, DESCR_COL,
                IMAGE_COL)
        val db = dbHelper.readableDatabase

        val order = "${ID} ASC"

//        cursor allows us to run through the values returned
        val cursor = db.doQuery(TABLE_NAME, columns,  orderBy = order)

        return parseHabitFrom(cursor)

    }


    private fun parseHabitFrom(cursor: Cursor): MutableList<Habit> {
        val habits = mutableListOf<Habit>()

        while (cursor.moveToNext()) {
            val title = cursor.getString((TITLE_COL))
            val desc = cursor.getString((DESCR_COL))
            val bitmap = cursor.getBitmap(IMAGE_COL)
            habits.add(Habit(title, desc, bitmap))
        }
        cursor.close()
        return habits
    }
    //    converting image to blob
    private fun toByteArray(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream)
        return stream.toByteArray()
    }

}

private fun Cursor.getBitmap(columnName: String):Bitmap {
    val bytes = getBlob(getColumnIndex(columnName))
    return BitmapFactory.decodeByteArray(bytes,0,bytes.size)
}


private fun Cursor.getString(columnName: String):String {
  return getString(getColumnIndex(columnName))
}



private fun SQLiteDatabase.doQuery(table: String, columns: Array<String>, selection: String? = null,
                                   selectionArgs: Array<String>? = null, groupBy: String? = null, having: String? = null,
                                   orderBy: String? = null): Cursor {
    return query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
}

private inline fun <T> SQLiteDatabase.transaction(function: SQLiteDatabase.() -> T): T {
    beginTransaction()
    val result = try {
        val returnValue = function()
        setTransactionSuccessful()

        returnValue
    } finally {
        endTransaction()
    }
    close()
    return result
}