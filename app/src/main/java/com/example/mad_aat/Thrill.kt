package com.example.mad_aat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Thrill : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thrill)
        val bookButtons = arrayOf(
            findViewById<Button>(R.id.bookButton),
            findViewById<Button>(R.id.bookButton1),
            findViewById<Button>(R.id.bookButton2),
            findViewById<Button>(R.id.bookButton3),
            findViewById<Button>(R.id.bookButton4),
            findViewById<Button>(R.id.bookButton5)
        )
        for (button in bookButtons) {
            button.setOnClickListener {
                val implicitintent= Intent(this,Form::class.java)
                startActivity(implicitintent)


            }
        }
    }
}