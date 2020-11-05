package com.pandamy.scantopdf.rv

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.pandamy.scantopdf.R
import kotlinx.android.synthetic.main.item_photo.view.*

class BitmapAdapter (val photos : List<Bitmap>, val itemClickListener: View.OnClickListener) : RecyclerView.Adapter<BitmapAdapter.ViewHolder>() {

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
        holder.photoBitmapView.setImageBitmap(photo)
    }

    override fun getItemCount(): Int {
        return photos.size
    }


}