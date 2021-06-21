package com.stark.learning.alertdialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.stark.learning.R

class IAlertDialog(iBuilder: IBuilder) {

    private var dialog: Dialog = iBuilder.dialog

    class IBuilder(context: Context) {
        var dialog: Dialog

        init {
            dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.ialertdialog)
            dialog.window!!.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!
                .setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.findViewById<TextView>(R.id.i_negative_btn)
                .setOnClickListener { dialog.dismiss() }

        }


        fun setCancelable(flag: Boolean): IBuilder {
            dialog.setCancelable(flag)
            return this
        }

        fun setTitle(title: String): IBuilder {
            dialog.findViewById<TextView>(R.id.i_title)
                .text = title.trim()
            return this
        }

        fun setMessage(title: String): IBuilder {
            dialog.findViewById<TextView>(R.id.i_message)
                .text = title.trim()
            return this
        }

        fun create() = IAlertDialog(this)

        fun getPositiveButton() = dialog.findViewById<TextView>(R.id.i_positive_btn)

        fun getNegativeButton() = dialog.findViewById<TextView>(R.id.i_negative_btn)

        fun setPositiveButton(
            positiveBtnText: String = "Okay",
            onClick: (view: View) -> Unit , dismiss : Boolean = false
        ): IBuilder {
            getPositiveButton().text = positiveBtnText

            if (dismiss){
                dialog.dismiss()
            }else {
                getPositiveButton().setOnClickListener(onClick)
            }
            return this
        }

        fun setNegativeButton(
            negativeButton: String = "Cancel",
            onClick: ((view: View) -> Unit)? = null , dismiss : Boolean = false
        ): IBuilder {
            getNegativeButton().text = negativeButton

            if (dismiss){
                dialog.dismiss()
            }else{
                getNegativeButton().setOnClickListener(onClick)
            }

            return this
        }


        private fun dismiss() = dialog.dismiss()

         fun setCornerRadius( cornerRadius : Float) : IBuilder{
           val gradientDrawable = GradientDrawable().apply {
               shape = GradientDrawable.RECTANGLE
               setColor(Color.WHITE)
               this.cornerRadius = cornerRadius
           }
             dialog.findViewById<ConstraintLayout>(R.id.i_alert_container).background=gradientDrawable

             return this
        }
    }

    fun show() = dialog.show()

    fun dismiss() = dialog.dismiss()


}