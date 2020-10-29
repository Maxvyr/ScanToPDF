package com.pandamy.scantopdf.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pandamy.scantopdf.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createScanFab.setOnClickListener { openCamera() }
    }

    private fun openCamera() {
        intent = Intent(this,ScanActivity::class.java)
        startActivity(intent)
    }
}