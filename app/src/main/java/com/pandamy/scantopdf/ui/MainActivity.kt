package com.pandamy.scantopdf.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.pandamy.scantopdf.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createScanFab.setOnClickListener {openCamera()}
        coodinatorLayoutMain.setOnClickListener(this)
    }

    private fun openCamera() {
        intent = Intent(this,ScanActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(p0: View?) {
        Log.d(TAG, "onClick main screen")
    }
}