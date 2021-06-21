package com.stark.learning.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.i
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.stark.learning.R
import kotlinx.android.synthetic.main.activity_rorate_image.*

class RotateManyImages : AppCompatActivity() {

    val images = ArrayList<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate_many_images)

       /*val imageView =   findViewById<ImageView>(
           resources.getIdentifier("iv1", "id",
               packageName
           ))*/
       // imageView.setImageDrawable(resources.getDrawable(R.drawable.background))

        for (i in 0 .. 66){
            images.add( findViewById<ImageView>(
                resources.getIdentifier("iv${i}", "id",
                packageName
            )))


            images[i].clipToOutline=true
            images[i].startAnimation(
                AnimationUtils.loadAnimation(this,R.anim.image_rotate)
            )
        }
    }
}