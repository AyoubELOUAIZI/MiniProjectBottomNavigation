package com.example.miniprojectbottomnavigation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ImageAdapter(private val imageList: ArrayList<Int>, private val viewPager2: ViewPager2) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.image_container, parent, false)
        return ImageViewHolder(view)
    }

//    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
//        holder.imageView.setImageResource(imageList[position])
//        if (position == imageList.size-1){
//            viewPager2.post(runnable)
//        }
//    }
    // Inside ImageAdapter's onBindViewHolder

//    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
//        val imageResId = imageList[position]
//
//        // Set image to ImageView in the ViewHolder
//        holder.imageView.setImageResource(imageResId)
//
//        // Add click listener to open fullscreen activity
//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, FullscreenImageActivity::class.java)
//            intent.putExtra("imageResId", imageResId)
//            holder.itemView.context.startActivity(intent)
//        }
//
//        if (position == imageList.size - 1) {
//            viewPager2.post(runnable)
//        }
//    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageResId = imageList[position]

        // Set image to ImageView in the ViewHolder
        holder.imageView.setImageResource(imageResId)

        // Set click listener to open fullscreen activity
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, FullscreenImageActivity::class.java)
            intent.putExtra("imageResId", imageResId)
            it.context.startActivity(intent)
        }

        if (position == imageList.size - 1) {
            viewPager2.post(runnable)
        }
    }


    override fun getItemCount(): Int {
        return imageList.size
    }

    private val runnable = Runnable {
        imageList.addAll(imageList)
        notifyDataSetChanged()
    }



}