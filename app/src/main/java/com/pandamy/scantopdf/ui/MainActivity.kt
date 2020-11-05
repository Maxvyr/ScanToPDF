package com.pandamy.scantopdf.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.pandamy.scantopdf.R
import com.pandamy.scantopdf.models.PhotoForScanning
import com.pandamy.scantopdf.rv.BitmapAdapter
import com.pandamy.scantopdf.utils.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var pictures : MutableList<PhotoForScanning>
    lateinit var adapter : BitmapAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init var
        pictures = mutableListOf()

        //init rv
        adapter = BitmapAdapter(pictures, this)
        rvScan.layoutManager = GridLayoutManager(this,3)
        rvScan.adapter = adapter

        // Request camera permissions
        if (allPermissionsGranted()) {
            //Showing the screen
        } else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS_CAMERA)
        }

        createScanFab.setOnClickListener(this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS_CAMERA ) {
                if (allPermissionsGranted()) {
                    Log.i(TAG, "onRequestPermissionsResult: Permission Granted")
                } else {
                    Toast.makeText(this,
                        noCameraPermission,
                        Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }

    /**
     * onActivityForResult
     * CAMERA_REQUEST => recover data send by the camera and save them
     * in the ImageView
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //if request code is equal to the screen of camera
        if (requestCode == CAMERA_REQUEST) {
            //recover the data and past them in the Bitmap
            Log.d(TAG, "onActivityResult: $data and convert them to bitmap")
            //image to bitmap
            val bitmap : Bitmap = data?.extras?.get("data") as Bitmap
            //id dataclass
            val id = Calendar.getInstance().timeInMillis
            //var data class
            val pictureTaking : PhotoForScanning = PhotoForScanning(id, bitmap)
            // add pictures to position 0 in the list
            pictures.add(0,pictureTaking)
            adapter.notifyDataSetChanged()
        }
    }

    /**
     * openCamera
     * and startActivityForResult => with the result of the snapshot
     */
    private fun openCamera() {
        intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE)
        startActivityForResult(intent, CAMERA_REQUEST)
    }

    /**
     * allPermissionFranted
     */
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(this,it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onClick(item: View) {
        Log.i(TAG, "onClick: Click")
        if (item.tag != null) {
            //todo show image
        }
        when(item.id){
            R.id.createScanFab -> openCamera()
        }
    }

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
        private const val REQUEST_CODE_PERMISSIONS_CAMERA = 20
        const val CAMERA_REQUEST = 42
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }
}