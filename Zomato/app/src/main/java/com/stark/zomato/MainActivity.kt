package com.example.nestedrecyclerview

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    lateinit var mainRecyclerView: RecyclerView
    var selectedRoomList = mutableSetOf<Room>()


    var roomList = mutableListOf<Room>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerView = findViewById(R.id.mainRecyclerView)



        for (room in 0..30) {
            var roomRateList = mutableListOf<RoomRate>()
            for (roomRate in 0..3) {
                roomRateList.add(RoomRate("rname ${room + roomRate}"))
            }


            roomList.add(Room("Room ${room}", roomRateList.toMutableList()))
        }

        mainRecyclerView.adapter = MainAdapter(roomList, object : OnItemClickListener<Room> {
            override fun onItemClick(
                view: View,
                position: Int,
                type: Int,
                isChecked: Boolean,
                roomRate: RoomRate,
                t: Room
            ) {


                var size = 0
                selectedRoomList.forEach {
                    size += it.roomRates.size
                }



                t.let { rooms ->


                    Log.d(TAG, "Checking Size : ${size} vs ${3}(Actual Size)")
                    if (4 > size) {

                        if (rooms.roomRates.size == 0) {
                            selectedRoomList.remove(rooms)
                            Log.d("TAG", "Item Removed ${rooms}")
                        } else {
                            selectedRoomList.add(rooms)
                        }


                        /*if (!selectedRoomList.contains(rooms)) {
                            Log.d("TAG", "Item Added ${rooms}")
                            selectedRoomList.add(rooms)
                        } else {


                        }*/
                        roomRate.isChecked = !roomRate.isChecked

                        if (roomRate.isChecked) {
                            (view as TextView).text = "Selected"
                        } else {
                            (view as TextView).text = "Select Room"
                        }
                    } else {
                        selectedRoomList.remove(rooms)
                        Toast.makeText(
                            this@MainActivity,
                            "Room Already Selected",
                            Toast.LENGTH_SHORT
                        ).show()
                        (view as TextView).text = "Select Room"
                        roomRate.isChecked = false
                    }

                }

                Log.d(TAG, "Im Here")
                selectedRoomList.forEach {
                    it.roomRates.forEach { rrate ->
                        Log.d(TAG, "Selected Room Rates : ${rrate}")
                    }
                }

                Log.d(TAG, "Im Here too")


            }
        })

        mainRecyclerView.setItemViewCacheSize(roomList.size)
    }
}


data class Room(val roomName: String, val roomRates: MutableList<RoomRate>)


data class RoomRate(val rateName: String, var isChecked: Boolean = false)