package com.example.globetrotterapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import androidx.appcompat.widget.AppCompatImageView


import com.google.android.material.textfield.TextInputEditText

class FlightDetailsActivity : AppCompatActivity() {

    private lateinit var departureAirport: TextView
    private lateinit var arrivalAirport: TextView
    private lateinit var departureTime: TextView
    private lateinit var arrivalTime: TextView
    private lateinit var editButton: Button
    private lateinit var confirmButton: Button
    private lateinit var planeIcon: AppCompatImageView // Add this line



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_details)

        departureAirport = findViewById(R.id.departureAirport1)
        arrivalAirport = findViewById(R.id.arrivalAirport1)
        departureTime = findViewById(R.id.departureTime1)
        arrivalTime = findViewById(R.id.arrivalTime1)
        editButton = findViewById(R.id.edit)
        confirmButton = findViewById(R.id.book3)
        planeIcon = findViewById(R.id.planeIcon) // Add this line


        val fromLocation = intent.getStringExtra("from") ?: ""
        val toLocation = intent.getStringExtra("to") ?: ""
        val firstName = intent.getStringExtra("firstName")?:""
        val departureTimeStr = intent.getStringExtra("departureTime") ?: ""
        val arrivalTimeStr = intent.getStringExtra("arrivalTime") ?: ""
        val iconResourceId = intent.getIntExtra("iconResourceId", -1)


        departureAirport.text = fromLocation
        arrivalAirport.text = toLocation
        departureTime.text = departureTimeStr
        arrivalTime.text = arrivalTimeStr

        if (iconResourceId != -1) {
            planeIcon.setImageResource(iconResourceId) // Set the icon
        }

        editButton.setOnClickListener {
            val intent = Intent(this, TravelActivity::class.java)
            startActivity(intent)
        }

        confirmButton.setOnClickListener {
            val intent = Intent(this, SeatSelectionActivity::class.java).apply {
                putExtra("from", fromLocation)
                putExtra("to", toLocation)
                putExtra("firstName", firstName)
                putExtra("email", intent.getStringExtra("email"))
                putExtra("name", intent.getStringExtra("name"))
                putExtra("departureTime", departureTimeStr)
                putExtra("arrivalTime", arrivalTimeStr)
                putExtra("iconResourceId", iconResourceId) // Pass the icon resource ID to the next activity

            }
            startActivity(intent)
        }
    }
}