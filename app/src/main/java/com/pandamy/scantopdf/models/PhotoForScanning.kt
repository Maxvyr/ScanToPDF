package com.pandamy.scantopdf.models

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photoScanning")
data class PhotoForScanning(
    @PrimaryKey
    var id : Long,
    @ColumnInfo(name = "photo_scan")
    var picture: Bitmap
)