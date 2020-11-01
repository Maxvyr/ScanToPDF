package com.pandamy.scantopdf.ui

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.pandamy.scantopdf.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createScanFab.setOnClickListener { openCamera() }
    }

    private fun openCamera() {
        intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)
        startActivityForResult(intent, CAMERA_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST) {
            Log.d(TAG, "onActivityResult: return")
            val bitmap : Bitmap = data?.extras?.get("data") as Bitmap
            imageViewTest.setImageBitmap(bitmap)
        }
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
        const val CAMERA_REQUEST = 42
    }
}