package com.stark.learning.util

import android.content.Context
import com.stark.learning.alertdialog.IAlertDialog

 fun showIAlertDialog(context : Context, any : Any = ""){
    IAlertDialog.IBuilder(context).setCancelable(false)
        .setTitle("Item ${any as Int}")
        .setMessage("Item $any Clicked")
        .setPositiveButton("Yes",{ })
        .setCornerRadius(50F)
        .setNegativeButton("No",dismiss = true)
        .create()
        .show()
}

