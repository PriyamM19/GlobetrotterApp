package com.example.globetrotterapp

import android.widget.Spinner
import android.widget.Toast
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SeatSelectionActivity : AppCompatActivity() {

    private var selectedSeat: String? = null
    private lateinit var firstName: String
    private lateinit var fromLocation: String
    private lateinit var toLocation: String
    private lateinit var departureTime: String
    private lateinit var arrivalTime: String
    private var iconResourceId: Int = -1




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection) // Replace with your actual XML layout name

        // Initialize buttons
        val button1A = findViewById<Button>(R.id.onea)
        val button1K = findViewById<Button>(R.id.onek)
        val button2A = findViewById<Button>(R.id.twoa)
        val button2C = findViewById<Button>(R.id.twoc)
        val button2D = findViewById<Button>(R.id.twod)
        val button2F = findViewById<Button>(R.id.twof)
        val button3A = findViewById<Button>(R.id.threeq)
        val button3C = findViewById<Button>(R.id.threec)
        val button3D = findViewById<Button>(R.id.threed)
        val button3F = findViewById<Button>(R.id.threef)
        val button4A = findViewById<Button>(R.id.foura)
        val button4B = findViewById<Button>(R.id.fourb)
        val button4C = findViewById<Button>(R.id.fourc)
        val button4D = findViewById<Button>(R.id.fourd)
        val button4E = findViewById<Button>(R.id.foure)
        val button4F = findViewById<Button>(R.id.fourf)
        val button5A = findViewById<Button>(R.id.fivea)
        val button5B = findViewById<Button>(R.id.fiveb)
        val button5C = findViewById<Button>(R.id.fivec)
        val button5D = findViewById<Button>(R.id.fived)
        val button5E = findViewById<Button>(R.id.fivee)
        val button5F = findViewById<Button>(R.id.fivef)
        val button6A = findViewById<Button>(R.id.sixa)
        val button6B = findViewById<Button>(R.id.sixb)
        val button6C = findViewById<Button>(R.id.sixc)
        val button6D = findViewById<Button>(R.id.sixd)
        val button6E = findViewById<Button>(R.id.sixe)
        val button6F = findViewById<Button>(R.id.sixf)
        val confirmButton = findViewById<Button>(R.id.book)

        fromLocation = intent.getStringExtra("from")?:""
        toLocation = intent.getStringExtra("to")?:""
        firstName = intent.getStringExtra("firstName")?:""
        departureTime = intent.getStringExtra("departureTime") ?: ""
        arrivalTime = intent.getStringExtra("arrivalTime") ?: ""
        iconResourceId = intent.getIntExtra("iconResourceId", -1)


        // Set up click listeners for the buttons
        button1A.setOnClickListener {
            showToast("This seat is reserved. Please select another seat")
        }

        button1K.setOnClickListener {
            selectSeat("1K")
        }

        button2A.setOnClickListener {
            selectSeat("2A")
        }

        button2C.setOnClickListener {
            selectSeat("2C")
        }

        button2D.setOnClickListener {
            showToast("This seat is reserved. Please select another seat")
        }

        button2F.setOnClickListener {
            selectSeat("2F")
        }

        button3A.setOnClickListener {
            selectSeat("3A")
        }
        button3C.setOnClickListener {
            selectSeat("3C")
        }

        button3D.setOnClickListener {
            selectSeat("3D")
        }

        button3F.setOnClickListener {
            showToast("This seat is reserved. Please select another seat")
        }

        button4A.setOnClickListener {
            selectSeat("4A")
        }

        button4B.setOnClickListener {
            selectSeat("4B")
        }

        button4C.setOnClickListener {
            selectSeat("4C")
        }

        button4D.setOnClickListener {
            selectSeat("4D")
        }

        button4E.setOnClickListener {
            selectSeat("4E")
        }

        button4F.setOnClickListener {
            selectSeat("4F")
        }

        button5A.setOnClickListener {
            selectSeat("5A")
        }

        button5B.setOnClickListener {
            selectSeat("5B")
        }

        button5C.setOnClickListener {
            selectSeat("5C")
        }

        button5D.setOnClickListener {
            showToast("This seat is reserved. Please select another seat")
        }

        button5E.setOnClickListener {
            showToast("This seat is reserved. Please select another seat")
        }

        button5F.setOnClickListener {
            selectSeat("5F")
        }

        button6A.setOnClickListener {
            selectSeat("6A")
        }
        button6B.setOnClickListener {
            selectSeat("6B")
        }

        button6C.setOnClickListener {
            selectSeat("6C")
        }

        button6D.setOnClickListener {
            selectSeat("6D")
        }

        button6E.setOnClickListener {
            selectSeat("6E")
        }

        button6F.setOnClickListener {
            selectSeat("6F")
        }

        confirmButton.setOnClickListener {
            if (selectedSeat != null) {
                navigateToNextActivity(selectedSeat.toString())
            } else {
                showToast("Please select a seat")
            }
        }
    }

    private fun selectSeat(seatNumber: String) {
        selectedSeat = seatNumber
        showToast("Selected seat: $seatNumber")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun navigateToNextActivity(seatNumber: String) {
        var databaseReference = FirebaseDatabase.getInstance().getReference().child("FlightsBooking")
        val booking = FlightsBooking(firstName,
            intent.getStringExtra("email").toString(), fromLocation, toLocation,seatNumber)
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(@NonNull snapshot: DataSnapshot) {
                // Example navigation to another activity
                val intent = Intent(baseContext, BoardingPassActivity::class.java).apply {
                    putExtra("from", fromLocation)
                    putExtra("to", toLocation)
                    putExtra("firstName", firstName)
                    putExtra("seatNumber",seatNumber)
                    putExtra("departureTime", departureTime)
                    putExtra("arrivalTime", arrivalTime)
                    putExtra("email", intent.getStringExtra("email"))
                    putExtra("name", intent.getStringExtra("name"))
                    putExtra("iconResourceId", iconResourceId) // Pass the icon resource ID to the next activity

                }
                intent.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }

            override fun onCancelled(@NonNull error: DatabaseError) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(baseContext, "Fail to add data $error", Toast.LENGTH_SHORT)
                    .show()
            }
        })

        databaseReference.push().setValue(booking)


    }
}