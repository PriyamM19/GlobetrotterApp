package com.example.globetrotterapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView

class FlightBookActivity : AppCompatActivity() {

    private lateinit var cardView1: CardView
    private lateinit var cardView2: CardView
    private lateinit var cardView3: CardView
    private lateinit var cardView4: CardView

    private lateinit var departureAirport1: TextView
    private lateinit var arrivalAirport1: TextView
    private lateinit var departureTime1: TextView
    private lateinit var arrivalTime1: TextView
    private lateinit var viewDetail1: Button
    private lateinit var planeIcon1: AppCompatImageView

    private lateinit var departureAirport2: TextView
    private lateinit var arrivalAirport2: TextView
    private lateinit var departureTime2: TextView
    private lateinit var arrivalTime2: TextView
    private lateinit var viewDetail2: Button
    private lateinit var planeIcon2: AppCompatImageView

    private lateinit var departureAirport3: TextView
    private lateinit var arrivalAirport3: TextView
    private lateinit var departureTime3: TextView
    private lateinit var arrivalTime3: TextView
    private lateinit var viewDetail3: Button
    private lateinit var planeIcon3: AppCompatImageView

    private lateinit var departureAirport4: TextView
    private lateinit var arrivalAirport4: TextView
    private lateinit var departureTime4: TextView
    private lateinit var arrivalTime4: TextView
    private lateinit var viewDetail4: Button
    private lateinit var planeIcon4: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_book)

        // Initialize CardViews
        cardView1 = findViewById(R.id.cardView1)
        cardView2 = findViewById(R.id.cardView2)
        cardView3 = findViewById(R.id.cardView3)
        cardView4 = findViewById(R.id.cardView4)

        // Initialize TextViews and Buttons for CardView 1
        departureAirport1 = findViewById(R.id.departureAirport1)
        arrivalAirport1 = findViewById(R.id.arrivalAirport1)
        departureTime1 = findViewById(R.id.departureTime1)
        arrivalTime1 = findViewById(R.id.arrivalTime1)
        viewDetail1 = findViewById(R.id.viewDetail1)
        planeIcon1 = findViewById(R.id.planeIcon1)

        // Initialize TextViews and Buttons for CardView 2
        departureAirport2 = findViewById(R.id.departureAirport2)
        arrivalAirport2 = findViewById(R.id.arrivalAirport2)
        departureTime2 = findViewById(R.id.departureTime2)
        arrivalTime2 = findViewById(R.id.arrivalTime2)
        viewDetail2 = findViewById(R.id.viewDetail2)
        planeIcon2 = findViewById(R.id.planeIcon2)

        // Initialize TextViews and Buttons for CardView 3
        departureAirport3 = findViewById(R.id.departureAirport3)
        arrivalAirport3 = findViewById(R.id.arrivalAirport3)
        departureTime3 = findViewById(R.id.departureTime3)
        arrivalTime3 = findViewById(R.id.arrivalTime3)
        viewDetail3 = findViewById(R.id.viewDetail3)
        planeIcon3 = findViewById(R.id.planeIcon3)

        // Initialize TextViews and Buttons for CardView 4
        departureAirport4 = findViewById(R.id.departureAirport4)
        arrivalAirport4 = findViewById(R.id.arrivalAirport4)
        departureTime4 = findViewById(R.id.departureTime4)
        arrivalTime4 = findViewById(R.id.arrivalTime4)
        viewDetail4 = findViewById(R.id.viewDetail4)
        planeIcon4 = findViewById(R.id.planeIcon4)

        val from = intent.getStringExtra("from") ?: ""
        val to = intent.getStringExtra("to") ?: ""
        val firstName = intent.getStringExtra("firstName") ?: ""

        // Set common values
        departureAirport1.text = from
        arrivalAirport1.text = to
        departureAirport2.text = from
        arrivalAirport2.text = to
        departureAirport3.text = from
        arrivalAirport3.text = to
        departureAirport4.text = from
        arrivalAirport4.text = to

        // Set departure and arrival times for each CardView (hardcoded for now)
        departureTime1.text = "10:00 AM" // Replace with actual departure time
        arrivalTime1.text = "12:00 PM" // Replace with actual arrival time
        departureTime2.text = "11:00 AM" // Replace with actual departure time
        arrivalTime2.text = "01:00 PM" // Replace with actual arrival time
        departureTime3.text = "02:00 PM" // Replace with actual departure time
        arrivalTime3.text = "04:00 PM" // Replace with actual arrival time
        departureTime4.text = "03:00 PM" // Replace with actual departure time
        arrivalTime4.text = "05:00 PM" // Replace with actual arrival time

        // Handle button clicks
        viewDetail1.setOnClickListener {
            val intent = Intent(this, FlightDetailsActivity::class.java).apply {
                putExtra("from", from)
                putExtra("to", to)
                putExtra("departureTime", departureTime1.text.toString())
                putExtra("arrivalTime", arrivalTime1.text.toString())
                putExtra("firstName", firstName)
                putExtra("email", intent.getStringExtra("email"))
                putExtra("name", intent.getStringExtra("name"))
                putExtra("iconResourceId", R.drawable.ai) // Replace with the actual icon resource ID
            }
            startActivity(intent)
        }

        viewDetail2.setOnClickListener {
            val intent = Intent(this, FlightDetailsActivity::class.java).apply {
                putExtra("from", from)
                putExtra("to", to)
                putExtra("departureTime", departureTime2.text.toString())
                putExtra("arrivalTime", arrivalTime2.text.toString())
                putExtra("firstName", firstName)
                putExtra("email", intent.getStringExtra("email"))
                putExtra("name", intent.getStringExtra("name"))
                putExtra("iconResourceId", R.drawable.klm) // Replace with the actual icon resource ID
            }
            startActivity(intent)
        }

        viewDetail3.setOnClickListener {
            val intent = Intent(this, FlightDetailsActivity::class.java).apply {
                putExtra("from", from)
                putExtra("to", to)
                putExtra("departureTime", departureTime3.text.toString())
                putExtra("arrivalTime", arrivalTime3.text.toString())
                putExtra("firstName", firstName)
                putExtra("email", intent.getStringExtra("email"))
                putExtra("name", intent.getStringExtra("name"))
                putExtra("iconResourceId", R.drawable.ac) // Replace with the actual icon resource ID
            }
            startActivity(intent)
        }

        viewDetail4.setOnClickListener {
            val intent = Intent(this, FlightDetailsActivity::class.java).apply {
                putExtra("from", from)
                putExtra("to", to)
                putExtra("departureTime", departureTime4.text.toString())
                putExtra("arrivalTime", arrivalTime4.text.toString())
                putExtra("firstName", firstName)
                putExtra("email", intent.getStringExtra("email"))
                putExtra("name", intent.getStringExtra("name"))
                putExtra("iconResourceId", R.drawable.emi) // Replace with the actual icon resource ID
            }
            startActivity(intent)
        }
    }
}