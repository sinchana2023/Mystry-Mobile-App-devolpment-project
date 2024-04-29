package com.example.mad_aat

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class contact : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        val em: TextView = findViewById(R.id.email1)
        em.setOnClickListener(View.OnClickListener { // To add fade animation
            val animation = AnimationUtils.loadAnimation(
                applicationContext, R.anim.blink
            )
            em.startAnimation(animation)
        })
    }
}