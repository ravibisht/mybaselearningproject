package com.stark.learning.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stark.learning.R

class LoginExActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_ex)
        supportActionBar?.hide()
    }
}