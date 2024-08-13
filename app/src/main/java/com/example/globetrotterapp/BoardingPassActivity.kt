package com.example.globetrotterapp


import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.FileProvider
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class BoardingPassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boarding_pass)


        val seatNumber = intent.getStringExtra("seatNumber")?:""
        val passengerName = intent.getStringExtra("firstName")?:"" // Retrieve this from wherever it was saved
        val gateNumber = "A6"
        val departureTime = intent.getStringExtra("departureTime") ?: ""
        val arrivalTime = intent.getStringExtra("arrivalTime") ?: ""

        val iconResourceId = intent.getIntExtra("iconResourceId", -1)

        // Initialize TextViews
        val seatNumberTextView = findViewById<TextView>(R.id.seatnumber)
        val passengerNameTextView = findViewById<TextView>(R.id.pname)
        val flightFromTextView = findViewById<TextView>(R.id.departureAirport1)
        val flightToTextView = findViewById<TextView>(R.id.arrivalAirport1)
        val departureTimeTextView = findViewById<TextView>(R.id.departureTime1)
        val arrivalTimeTextView = findViewById<TextView>(R.id.arrivalTime1)
        val gateNumberTextView = findViewById<TextView>(R.id.gatenumber)
        val cardView = findViewById<CardView>(R.id.cardView1)
        val airlineIconImageView = findViewById<ImageView>(R.id.airlineIconImageView)

        // Set values
        seatNumberTextView.text = seatNumber
        passengerNameTextView.text = passengerName
        flightFromTextView.text = intent.getStringExtra("from")?:""
        flightToTextView.text = intent.getStringExtra("to")?:""
        departureTimeTextView.text = departureTime
        arrivalTimeTextView.text = arrivalTime
        gateNumberTextView.text = gateNumber

        if (iconResourceId != -1) {
            airlineIconImageView.setImageResource(iconResourceId)
        }


        // Set up click listener for the download button
        val downloadButton = findViewById<Button>(R.id.shareBtn)
        downloadButton.setOnClickListener {
            shareBoardingPass(cardView)
        }

        val mainButton = findViewById<Button>(R.id.BookingPage)
        mainButton.setOnClickListener {
            val intent = Intent(baseContext, MainActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtra("email",getIntent().getStringExtra("email"))
            intent.putExtra("name", getIntent().getStringExtra("name"))
            startActivity(intent)
            finish()
        }
    }

    fun shareBoardingPass(view: View){
        val bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)

        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path: String = MediaStore.Images.Media.insertImage(
            contentResolver,
            bitmap,
            "Title",
            null
        )
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(path))
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.setType("image/*")
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(baseContext, MainActivity::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra("email",getIntent().getStringExtra("email"))
        intent.putExtra("name", getIntent().getStringExtra("name"))
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}