package com.vinicius.habittrainer

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.EditText
import com.vinicius.habittrainer.db.HabitDbTable
import kotlinx.android.synthetic.main.activity_create_habit.*

import java.io.IOException

class CreateHabitActivity : AppCompatActivity() {

    private val TAG = CreateHabitActivity::class.java.simpleName

    private val CHOOSE_IMAGE_REQUEST = 1

    private var imageBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_habit)
    }

    fun storeHabit(v: View) {
        if (et_title.isBlank() || et_description.isBlank()) {
            Log.d(TAG, "NO habit stored, title or description missing")
            displayErrorMessage("Your habit need an engaging title and description")
            return
        } else if (imageBitmap == null) {
            Log.d(TAG, "No habit stored: image missing")
            displayErrorMessage("Add a motivating picture to your new habit")
            return
        }

        tv_error.visibility = View.INVISIBLE

        // store a habit....
        val title = et_title.text.toString()
        val description = et_description.text.toString()
        val habit = Habit(title,description, imageBitmap!!)

        val id = HabitDbTable(this).store(habit)

        if(id == -1L) {
            displayErrorMessage("Error storing habit ")
        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    fun displayErrorMessage(message: String) {
        tv_error.text = message
        tv_error.visibility = View.VISIBLE
    }

    fun chooseImage(v: View) {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        val chooser = Intent.createChooser(intent, "CHoose image for habit")
        startActivityForResult(chooser, CHOOSE_IMAGE_REQUEST)

        Log.i(TAG, "INTENT TO CHOOSE IMAGE SENT...")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CHOOSE_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            Log.d(TAG, "An image was chosen byt yhe user")

            val bitmap = tryReadBitmap(data.data)

            bitmap?.let {
                this.imageBitmap = bitmap
                iv_image.setImageBitmap(this.imageBitmap)
                Log.d(TAG, "Image read and updated to imageview")
            }
        }
    }

    private fun tryReadBitmap(data: Uri): Bitmap? {
        return try {
            MediaStore.Images.Media.getBitmap(contentResolver, data)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}

private fun EditText.isBlank() = this.text.toString().isBlank()