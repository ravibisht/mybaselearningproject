package com.stark.learning.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stark.learning.R
import kotlinx.android.synthetic.main.staggered_ltems.view.*
import kotlin.math.hypot

class StaggeredRecyclerView(private val itemList: MutableList<Any>,
                           val onClick : (position : Int) -> Unit ):
    RecyclerView.Adapter<StaggeredRecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.staggered_ltems,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.itemId.apply {
            text = itemList[position].toString()
            isSelected=true
            setOnClickListener {
/*                val revealAnimation = ViewAnimationUtils.createCircularReveal(holder.itemView.itemId,
                    0,0, 0F,
                    hypot(1000.toDouble(), 1000.toDouble()).toFloat())
                revealAnimation.interpolator=AccelerateDecelerateInterpolator()
                revealAnimation.duration=3000
                revealAnimation.start()*/

                onClick(position)
            }
        }

    }


    override fun getItemCount() = itemList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}