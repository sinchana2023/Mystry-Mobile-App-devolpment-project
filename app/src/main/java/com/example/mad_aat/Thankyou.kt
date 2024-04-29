package com.example.mad_aat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Thankyou : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thankyou)

        val numofguests = intent.getStringExtra("numofguest")
        val date = intent.getStringExtra("checkindate")

        val text2 = findViewById<TextView>(R.id.text2)
        val text4 = findViewById<TextView>(R.id.text4)
        val book:TextView=findViewById(R.id.bookingtext)
        book.setOnClickListener(View.OnClickListener { // To add fade animation
            val animation = AnimationUtils.loadAnimation(
                applicationContext, R.anim.slide
            )
            book.startAnimation(animation)
        })


        text2.text="Number of Guests: $numofguests"
        text4.text="Checkin Date: $date"

        val btn=findViewById<Button>(R.id.btn_rtn)
        btn.setOnClickListener {
            val sub = Intent(this,review::class.java)
            startActivity(sub)
            // using finish() to end the activity
            finish()

        }
    }

}