package com.stark.learning.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stark.learning.R
import kotlinx.android.synthetic.main.dummy_items.*

class MyRecyclerAdapter : RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(

            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.dummy_items ,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text="hello world ${position}"
    }

    class ViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem) {

        val textView =  viewItem.findViewById<TextView>(R.id.textView)
    }

}