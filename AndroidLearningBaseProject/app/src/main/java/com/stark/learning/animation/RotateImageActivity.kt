package com.stark.learning.animation

import android.animation.Animator
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.stark.learning.R
import com.stark.learning.alertdialog.IAlertDialog
import kotlinx.android.synthetic.main.activity_rorate_image.*
class RotateImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rorate_image)
      //  rotateImage()

        image.clipToOutline=true
        rotateImageUsingAnim()

         IAlertDialog.IBuilder(this).setCancelable(false)
            .setTitle("Location Service Off")
            .setMessage("Turn on Location Services in Setting > Privacy to allow Maps to determine your current location")
            .create()
            .show()

    }

    private fun rotateImage(){
        image.animate().apply {
            duration=1000
            /*scaleX(-1f)*/
            // scaleY(-1f)
            yBy(0.5f)
            xBy(0.5f)
            rotation(360f)
            start()
            /*setListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                    animation
                }

                override fun onAnimationEnd(animation: Animator?) {

                    rotateImage()
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }

            })*/
        }
    }

    private fun rotateImageUsingAnim(){
        image.startAnimation(
                AnimationUtils.loadAnimation(this,R.anim.image_rotate)
        )
    }
}