package com.example.mad_aat

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val im: ImageView = findViewById(R.id.imageView2)
        im.setOnClickListener(View.OnClickListener { // To add fade animation
            val animation = AnimationUtils.loadAnimation(
                applicationContext, R.anim.move
            )
            im.startAnimation(animation)
        })
    }
}