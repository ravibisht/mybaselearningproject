package com.stark.learning.design

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.stark.learning.R
import com.stark.learning.util.showIAlertDialog
import kotlinx.android.synthetic.main.content_bottom_sheet.*
import kotlinx.android.synthetic.main.content_bottom_sheet.bottomSheetTop
import kotlinx.android.synthetic.main.content_bottom_sheet.dummyList
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

class BottomSheet : AppCompatActivity() {
    private  val TAG = "BottomSheet"
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)
        setSupportActionBar(findViewById(R.id.toolbar))

         dummyList.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
           MutableList(1000) { i -> "Item $i"}
         )



        dummyList.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                showIAlertDialog(this@BottomSheet,position)
                Log.d(TAG, "onItemClick: ${dummyList.getItemAtPosition(position) as String}")

            }
        }

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        bottomSheetBehavior.addBottomSheetCallback( object :
            BottomSheetBehavior.BottomSheetCallback() {

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
              bottomSheetTop.text = when(newState){
                  BottomSheetBehavior.STATE_EXPANDED -> "Bottom Sheet Opened"
                  BottomSheetBehavior.STATE_COLLAPSED -> "Open Bottom Sheet"
                  BottomSheetBehavior.STATE_HALF_EXPANDED -> "Opening Bottom Sheet"
                  else-> "Bottom Sheet Changing "
              }
            }
        }
        )


        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            bottomSheetBehavior.state = if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                                            BottomSheetBehavior.STATE_COLLAPSED else BottomSheetBehavior.STATE_HALF_EXPANDED
        }

    }



}
