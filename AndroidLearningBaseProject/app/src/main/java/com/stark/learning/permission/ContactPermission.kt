package com.stark.learning.permission

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.Settings
import android.util.Log
import android.view.ContextMenu
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.stark.learning.R
import kotlinx.android.synthetic.main.activity_contact_permission.*

class ContactPermission : AppCompatActivity(R.layout.activity_contact_permission){
    private  val TAG = "ContactPermission"
    
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         ask_contact_permission.setOnClickListener {checkPermission(this) }
     }






    
     private fun checkPermission(context : Context) : Boolean{
         if(ActivityCompat
                 .checkSelfPermission(
                     context,
                     android.Manifest.permission.READ_CONTACTS)
             != PackageManager.PERMISSION_GRANTED ){

             Log.d(TAG, "checkPermission Rationale: ${ActivityCompat
                 .shouldShowRequestPermissionRationale(this,
                     android.Manifest.permission.READ_CONTACTS)}")

                 requestPermissions(arrayOf(android.Manifest.permission.READ_CONTACTS),333)

         }

         return false
     }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if (requestCode== 333 &&
            grantResults.isNotEmpty() &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED ){


        }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){

            if (!ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    android.Manifest.permission.READ_CONTACTS)){
                val intent =  Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", this.packageName, null)
                )
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivityForResult(intent, 789)
            }
        }
    }

 }