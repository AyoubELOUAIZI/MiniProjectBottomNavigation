// FullscreenImageActivity.kt

package com.example.miniprojectbottomnavigation

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FullscreenImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen_image)

        val imageView = findViewById<ImageView>(R.id.fullscreenImageView)

        // Get the image resource ID from the intent
        val imageResId = intent.getIntExtra("imageResId", 0)

        // Set the image in fullscreen
        imageView.setImageResource(imageResId)
    }
}
