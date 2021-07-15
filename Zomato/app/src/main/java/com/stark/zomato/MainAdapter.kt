package com.example.nestedrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val roomList: MutableList<Room>,
    val onItemClickListener: OnItemClickListener<Room>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val TAG = "MainAdapter"
    public val subAdapterMap = HashMap<SubAdapter, Room>()
    public val subAdapterList = mutableListOf<SubAdapter>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.room, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.bind(roomList[position], onItemClickListener)

    }

    override fun getItemCount(): Int {
        return roomList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val TAG = "MainAdapter"
        var selectedRooms: Room? = null

        val roomName: TextView = itemView.findViewById(R.id.title)
        val submRecyclerView: RecyclerView = itemView.findViewById(R.id.subRecyclerView)


        fun bind(room: Room, onItemClickListener: OnItemClickListener<Room>) {
            roomName.text = room.roomName
            submRecyclerView.setItemViewCacheSize(room.roomRates.size)
            subAdapterList
                .add(
                    SubAdapter(
                        room.roomRates, object : OnItemClickListener<RoomRate> {
                            override fun onItemClick(
                                view: View,
                                position: Int,
                                type: Int,
                                isChecked: Boolean,
                                roomRate: RoomRate,
                                t: RoomRate
                            ) {

                                selectedRooms = subAdapterMap[subAdapterList[adapterPosition]]

                                if (selectedRooms != null) {

                                    if (!selectedRooms!!.roomRates.contains(t)) {
                                        Log.d(TAG, "onItemClick: Adding this room ${t}")
                                        selectedRooms!!.roomRates.add(t)

                                    } else {
                                        selectedRooms!!.roomRates.remove(t)
                                        Log.d(TAG, "onItemClick: Removing this room ${t}")
                                    }
                                } else {
                                    subAdapterMap[subAdapterList[adapterPosition]] = Room(
                                        roomList[adapterPosition].roomName,
                                        mutableListOf<RoomRate>(t)
                                    )
                                }





                                selectedRooms?.let {
                                    subAdapterMap[subAdapterList[adapterPosition]] = selectedRooms!!
                                }
                                subAdapterMap[subAdapterList[adapterPosition]]?.let {

                                    onItemClickListener.onItemClick(
                                        view, position, 0,
                                        t.isChecked, roomRate, it
                                    )
                                }
                            }
                        }
                    )
                )

            submRecyclerView.adapter = subAdapterList[adapterPosition]

        }


    }
}