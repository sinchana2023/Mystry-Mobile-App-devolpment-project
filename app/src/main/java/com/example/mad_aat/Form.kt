package com.example.mad_aat

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Form : AppCompatActivity() {

    private lateinit var e1: EditText
    private lateinit var e2: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var numofguest: EditText
    private lateinit var confirmBookingButton: Button
    private lateinit var checkindate:EditText
    private lateinit var dateEditText: EditText

    // Get a reference to the Firebase database
    private lateinit var databaseReference: DatabaseReference

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("bookings")

        // Initialize views
        e1 = findViewById(R.id.e1)
        e2 = findViewById(R.id.e2)
        email = findViewById(R.id.email)
        phone = findViewById(R.id.phone)
        numofguest = findViewById(R.id.numofguest)
        confirmBookingButton = findViewById(R.id.form_btn1)
        checkindate = findViewById(R.id.dateEditText)
        val btn=findViewById<Button>(R.id.form_btn1)

        // Set onClickListener for the Confirm Booking button
        btn.setOnClickListener {

            if (e1.isEmpty()) {
                Toast.makeText(this@Form, "Please enter First Name", Toast.LENGTH_SHORT).show()
            } else if (email.isEmpty()) {
                Toast.makeText(this@Form, "Please enter Email", Toast.LENGTH_SHORT).show()
            } else if (phone.isEmpty()) {
                Toast.makeText(this@Form, "Please enter Phone Number", Toast.LENGTH_SHORT).show()
            } else if (checkindate.isEmpty()) {
                Toast.makeText(this@Form, "Please enter Checkin Date", Toast.LENGTH_SHORT).show()
            } else {
                saveBookingToFirebase()
                Toast.makeText(this, "Booking Confirmed", Toast.LENGTH_SHORT).show()


                val sub = Intent(this, Thankyou::class.java)
                sub.putExtra("numofguest", numofguest.text.toString())
                sub.putExtra("checkindate", checkindate.text.toString())
                startActivity(sub)
                // using finish() to end the activity
                finish()
            }
        }



        dateEditText = findViewById(R.id.dateEditText)
    }

    private fun saveBookingToFirebase() {
        // Get values from EditText fields
        val fname = e1.text.toString()
        val lname = e2.text.toString()
        val userEmail = email.text.toString()
        val userPhone = phone.text.toString()
        val numberOfGuests = numofguest.text.toString()

            // Create a BookingModel object
            val bookingModel = BookingModel(
                fname = fname,
                lname = lname,
                email = userEmail,
                phone = userPhone,
                numofguest = numberOfGuests
            )

            // Generate a unique key for the booking
            val bookingId = databaseReference.push().key

            // Save the booking to Firebase
            bookingId?.let {
                databaseReference.child(it).setValue(bookingModel)
            }

            // Display a success message or handle further actions
            // (e.g., navigate to another activity, show a toast, etc.)

    }
    fun showDatePickerDialog(view: View) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                dateEditText.setText(formattedDate)
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }
}

private fun EditText.isEmpty(): Boolean {

        return this.text.toString().trim().isEmpty()

}







