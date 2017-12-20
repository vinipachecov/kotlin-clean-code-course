package com.vinicius.habittrainer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import kotlinx.android.synthetic.main.single_card.view.*

/**
 * Created by vinicius on 12/20/17.
 */

class HabitsAdapter(val habits: List<Habit>) : RecyclerView.Adapter<HabitsAdapter.HabitViewHolder>() {


    // object that stores the reference to the view
    class HabitViewHolder(val card: View) : RecyclerView.ViewHolder(card)


    //    Specify the contents for the shown item/habit
    override fun onBindViewHolder(holder: HabitViewHolder?, index: Int) {
        if(holder != null){
            val habit = habits[index]
            holder.card.tv_title.text = habit.title
            holder.card.tv_description.text = habit.desciption
            holder.card.iv_icon.setImageBitmap(habit.image)
        }
    }


    //    create a new view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_card, parent, false )
        return HabitViewHolder(view)
    }


    override fun getItemCount() = habits.size



}