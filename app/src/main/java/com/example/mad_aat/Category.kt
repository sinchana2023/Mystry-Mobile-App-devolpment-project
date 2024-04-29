package com.example.mad_aat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class Category : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        val imgbtn = findViewById<ImageButton>(R.id.treat)
        val imgbtn1 = findViewById<ImageButton>(R.id.art)
        val imgbtn2 = findViewById<ImageButton>(R.id.broken)
        val imgbtn3 = findViewById<ImageButton>(R.id.book)
        val imgbtn4 = findViewById<ImageButton>(R.id.nature)
        val imgbtn5 = findViewById<ImageButton>(R.id.thrill)
        imgbtn.setOnClickListener {

            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        imgbtn1.setOnClickListener {

            val intent = Intent(this, Art::class.java)
            startActivity(intent)
        }
        imgbtn2.setOnClickListener {

            val intent = Intent(this, Broken::class.java)
            startActivity(intent)
        }
        imgbtn3.setOnClickListener {

            val intent = Intent(this, Library::class.java)
            startActivity(intent)
        }
        imgbtn4.setOnClickListener {

            val intent = Intent(this, Nature::class.java)
            startActivity(intent)
        }
        imgbtn5.setOnClickListener {

            val intent = Intent(this, Thrill::class.java)
            startActivity(intent)
        }
    }
}