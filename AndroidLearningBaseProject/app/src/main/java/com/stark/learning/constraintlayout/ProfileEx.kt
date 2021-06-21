package com.stark.learning.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stark.learning.R

class ProfileEx : AppCompatActivity(R.layout.activity_profile_ex) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
    }
}