package com.pandamy.scantopdf.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.pandamy.scantopdf.R
import com.pandamy.scantopdf.models.PhotoForScanning

class BitmapAdapter (val photos : List<PhotoForScanning>, val itemClickListener: View.OnClickListener) : RecyclerView.Adapter<BitmapAdapter.ViewHolder>() {

    class ViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView) {
        val cardView : CardView = itemView.findViewById<CardView>(R.id.cardView)
        val photoBitmapView: ImageView = itemView.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_photo, parent,false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val photo = photos[position]
        holder.cardView.setOnClickListener(itemClickListener)
        holder.cardView.tag = position
        //update image with potho of the data class
        holder.photoBitmapView.setImageBitmap(photo.picture)
    }

    override fun getItemCount(): Int {
        return photos.size
    }


}