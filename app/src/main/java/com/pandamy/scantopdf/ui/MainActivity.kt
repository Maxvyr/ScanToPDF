package com.pandamy.scantopdf.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.pandamy.scantopdf.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createScanFab.setOnClickListener { it -> openCamera() }
    }

    private fun openCamera() {
        intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)
        startActivity(intent)
    }
}