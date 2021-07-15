package com.example.nestedrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubAdapter(
    val roomRates: MutableList<RoomRate>,
    val onItemClickListener: OnItemClickListener<RoomRate>
) :
    RecyclerView.Adapter<SubAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.room_rate, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.bind(roomRates[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return roomRates.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val roomRateName: TextView = itemView.findViewById(R.id.idRoomRate)
        val selectBtn: TextView = itemView.findViewById(R.id.selectBtn)

        fun bind(roomRate: RoomRate, onItemClickListener: OnItemClickListener<RoomRate>) {
            roomRateName.text = roomRate.rateName
            if (roomRate.isChecked) {
                selectBtn.text = "Selected"
            }


            selectBtn.setOnClickListener {
//                roomRate.isChecked = !roomRate.isChecked
                onItemClickListener.onItemClick(selectBtn, adapterPosition, 0,roomRate.isChecked, roomRate,roomRate)
            }
        }
    }
}