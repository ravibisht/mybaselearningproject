package com.stark.learning.core

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_PICK
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.stark.learning.R
import kotlinx.android.synthetic.main.activity_main3.*
import java.io.File
import java.io.FileInputStream
import java.util.*

class MainActivity2 : AppCompatActivity() {

    private val TAG = "MainActivity2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        imageView6.setOnClickListener {
            startActivityForResult(
                Intent(ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI).apply {
                    type = "image/*"
                    flags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                }, 555
            )
        }

        imageView6.setOnLongClickListener {

            return@setOnLongClickListener true
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.e(TAG, "onActivityResult: ${data?.data}")
        imageView6.setImageURI(data?.data)

        //savePhotoToInternalStorage((imageView6.drawable as BitmapDrawable).bitmap)
        savePhotoToInternalStorage(uri = data?.data)

/*        data?.data?.let {
            val inputStream = contentResolver.openInputStream(it)
            val outPutStream = FileOutputStream(File("${UUID.randomUUID()}"))
            
        }*/

        Log.d(TAG, "onActivityResult: ${File(data?.data?.path)}")
        Log.e(TAG, "onActivityResult: ${File(data?.data?.path).path}")
        Log.e(TAG, "onActivityResult: ${File(data?.data?.path).absolutePath}")
        Log.d(TAG, "onActivityResult: ${data?.data?.path}")
        Log.e(TAG, "onActivityResult: ${File(data?.data?.path).length()}")
        Log.e(TAG, "onActivityResult1: ${getRealPathFromUri(data?.data ?: Uri.parse(""))}")
        Log.e(
            TAG,
            "onActivityResult2: ${File(getRealPathFromUri(data?.data ?: Uri.parse(""))).length()}"
        )


    }


    fun Activity.getRealPathFromUri(uri: Uri): String {
        val cursor = this.contentResolver.query(uri, null, null, null, null)
        if (cursor != null && cursor.moveToFirst()) {
            return cursor.getString(
                cursor.getColumnIndex(
                    MediaStore.Images.ImageColumns.DATA
                )
            )
        }
        return ""
    }

    fun Activity.savePhotoToInternalStorage(
        name: String = UUID.randomUUID().toString() + System.currentTimeMillis(),
        uri: Uri? = null,
        bitmap: Bitmap? = null
    ) {

        this.openFileOutput(name, MODE_PRIVATE).use {
            if (uri != null) {
                val file = File(getRealPathFromUri(uri))
                val fileInputStream = FileInputStream(file)

                fileInputStream.copyTo(it)
            }
            /*if (!bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, it)!!) {
                throw IOException("Couldn't Save the photo")
            }*/
        }
    }
}