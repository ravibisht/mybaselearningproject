package com.stark.learning.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.stark.learning.R
import com.stark.learning.component.Test


class CustomArrayAdapter(val mContext : Context, val resourseId : Int, private val testList: MutableList<Test>)
    : ArrayAdapter<Test>(mContext,resourseId,testList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return this.createCustomView(position, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return this.createCustomView(position, parent)
    }

    private fun createCustomView(position: Int,parent: ViewGroup) : View{
        return LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.custom_spinner,
                parent,
                false
            ).apply {
            this.findViewById<ImageView>(R.id.imageView8)
            this.findViewById<TextView>(R.id.textview8).text = testList[position].name
        }
    }
}
