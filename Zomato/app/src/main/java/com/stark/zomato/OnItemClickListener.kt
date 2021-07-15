package com.example.nestedrecyclerview

import android.view.View

interface OnItemClickListener<T> {
    fun onItemClick(view: View, position: Int, type: Int,isChecked : Boolean, roomRate: RoomRate,t: T)

}