package com.stark.learning

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.stark.learning.alertdialog.IAlertDialog
import com.stark.learning.animation.RotateImageActivity
import com.stark.learning.animation.RotateManyImages
import com.stark.learning.constraintlayout.CLL2
import com.stark.learning.constraintlayout.ConstraintLayoutEx
import com.stark.learning.constraintlayout.LoginExActivity
import com.stark.learning.constraintlayout.ProfileEx
import com.stark.learning.core.ItemDetailHostActivity
import com.stark.learning.coroutines.CWithP
import com.stark.learning.coroutines.CoroutineStarter
import com.stark.learning.design.BottomSheet
import com.stark.learning.design.FragmentBottomSheet
import com.stark.learning.permission.ContactPermission
import com.stark.learning.recyclerview.NestedRecyclerView
import com.stark.learning.recyclerview.StaggeredRecyclerView
import com.stark.learning.testing.TestActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.stark.learning.core.MainActivity
import com.stark.learning.core.MainActivity2
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private var onClickListener = mutableListOf<View>()
    private lateinit var listItems: MutableList<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listItems = mutableListOf(
            "Test Activity",
            "Rotate Image",
            "Rotate Images",
            "IAlert",
            "Recycler View",
            "C layout",
            "Bottom Layout",
            "Bottom Sheet Fragment",
            "Contact Permission",
            "Coroutine",
            "Login Ex",
            "CLL2",
            "Profile Ex",
            "C with P",
            "Image Upload",
            "On Test",
            "TV"
        )

        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL).apply {
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
            }
        recyclerView.adapter = StaggeredRecyclerView(
            listItems
        ) { performClick(it) }

    }


    private fun performClick(item: Int) {
        when (item) {
            0 -> startActivity(TestActivity::class)
            1 -> startActivity(RotateImageActivity::class)
            2 -> startActivity(RotateManyImages::class)
            3 -> showIAlertDialog()
            4 -> startActivity(NestedRecyclerView::class)
            5 -> startActivity(ConstraintLayoutEx::class)
            6 -> startActivity(BottomSheet::class)
            7 -> FragmentBottomSheet().show(supportFragmentManager, "")
            8 -> startActivity(ContactPermission::class)
            9 -> startActivity(CoroutineStarter::class)
            10 -> startActivity(LoginExActivity::class)
            11 -> startActivity(CLL2::class)
            12 -> startActivity(ProfileEx::class)
            13 -> startActivity(CWithP::class)
            14 -> startActivity(MainActivity2::class)
            15 -> startActivity(ItemDetailHostActivity::class)
            16 -> startActivity(MainActivity::class)
        }
    }

    private fun startActivity(any: KClass<*>) {
        startActivity(Intent(this, any.java))
    }

    fun Activity.startActivity(any: KClass<*>) {
        startActivity(Intent(this, any.java))
    }

    private fun showIAlertDialog() {
        IAlertDialog.IBuilder(this).setCancelable(false)
            .setTitle("Location Service Off")
            .setMessage("Turn on Location Services in Setting > Privacy to allow Maps to determine your current location")
            .setPositiveButton("Yes", { startActivity(RotateImageActivity::class) })
            .setCornerRadius(50F)
            .setNegativeButton("No", dismiss = true)
            .create()
            .show()

    }

}


/*private fun setOnClickListener(){
    for (view in onClickListener){
         view.setOnClickListener(this)
    }
}*/


/*onClickListener = mutableListOf(
    rotateImage ,
    rotateImages,
    iAlert,
    recyclerView,
    constraintLayout1,
    bottomSheet
)*/
//setOnClickListener()

