package com.example.mad_aat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class review : AppCompatActivity()  {

    // Reference to Firebase Database
    private val database = FirebaseDatabase.getInstance()
    private val feedbackRef = database.getReference("feedback")  // Change "feedback" to your desired Firebase node

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        // Assuming you have references to your UI elements
        val feedbackEditText: EditText = findViewById(R.id.feedback)
        val ratingBar: RatingBar = findViewById(R.id.stars)
        val sendFeedbackButton: Button = findViewById(R.id.button1)
        val home:Button=findViewById(R.id.button)
        val ratingText: TextView = findViewById(R.id.nameofrate)

        sendFeedbackButton.setOnClickListener {
            // Get feedback and rating values
            val userFeedback = feedbackEditText.text.toString()
            val userRating = ratingBar.rating.toString()

            // Create a reviewModel instance with the feedback and rating
            val review = reviewModel(rating = userRating, feedback = userFeedback)

            // Push the review data to Firebase
            feedbackRef.push().setValue(review)

            // Optionally, clear the EditText for the next feedback
            feedbackEditText.text.clear()
        }
       home.setOnClickListener {
            val sub = Intent(this,Home::class.java)
            startActivity(sub)
            // using finish() to end the activity
            finish()

        }
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            // Update the text view based on the rating value
            ratingText.text = when (rating.toInt()) {
                1 -> "Very Dissatisfied"
                2 -> "Dissatisfied"
                3 -> "Neutral"
                4 -> "Satisfied"
                5 -> "Very Satisfied"
                else -> ""
            }
        }
    }
}


