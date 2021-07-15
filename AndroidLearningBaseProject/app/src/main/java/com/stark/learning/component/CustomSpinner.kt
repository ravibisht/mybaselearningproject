package com.stark.learning.component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.stark.learning.R
import com.stark.learning.adapter.CustomArrayAdapter
import kotlinx.android.synthetic.main.activity_custom_spinner.*

class CustomSpinner : AppCompatActivity() {

    val list = mutableListOf(
    Test("ravindra","title1"),
    Test("Stark","title2"),
    Test("Mac ","title3"),
    Test("Windows","title4")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_spinner)

        textView.setOnClickListener {
            spinner.performClick()
        }

        spinner.adapter = CustomArrayAdapter(
            this,
            R.layout.custom_spinner,
            list
        )

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                Toast.makeText(this@CustomSpinner, "${list[position].name}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}



    data class Test(val name : String,val title :String)
