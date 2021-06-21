package com.stark.learning.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.stark.learning.R
import kotlinx.android.synthetic.main.activity_nested_recycler_view.*

class NestedRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_recycler_view)
        recyclerView.adapter= MyRecyclerAdapter()
        recyclerView.layoutManager=LinearLayoutManager(this)

    }
}