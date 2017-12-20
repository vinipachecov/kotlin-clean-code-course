package com.vinicius.habittrainer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.vinicius.habittrainer.db.HabitDbTable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.single_card.*

class MainActivity : AppCompatActivity() {

    // java way
//    private var tvDescription: TextView? = null

//    kotlin
    //private lateinit var tvDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        get reference to textview


//        using the call operator '?' we can only set the value if it is not null

//        using the xml id to call the functions
//        tv_description.text = getString(R.string.drink_water_description)
//        iv_icon.setImageResource(R.drawable.water)
//        tv_title.text = getString(R.string.drink_water)

//        Adapter -> defines data
//        recyclerVIew -> implements 3 methods
        rv.setHasFixedSize(true)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = HabitsAdapter(HabitDbTable(this).readAllHabits())
    }

//    attach our menu to the view
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if( item.itemId == R.id.add_habit) {
//            Intent(context, java file
            switch(CreateHabitActivity::class.java)
        }
        return true
    }

    private fun switch(c: Class<*>){
        val intent = Intent(this, c)
        startActivity(intent)
    }

}
