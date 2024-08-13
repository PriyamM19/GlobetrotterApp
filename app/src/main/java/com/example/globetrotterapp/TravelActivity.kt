package com.example.globetrotterapp

import android.util.Log
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import android.widget.ArrayAdapter

class TravelActivity : AppCompatActivity() {

    private lateinit var firstName: TextInputEditText
    private lateinit var lastName: TextInputEditText
    private lateinit var genderGroup: RadioGroup
    private lateinit var fromSpinner: Spinner
    private lateinit var toSpinner: Spinner
    private lateinit var dateOfTravel: EditText
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel)

        firstName = findViewById(R.id.editfname)
        lastName = findViewById(R.id.editlname)
        genderGroup = findViewById(R.id.radioGroup)
        fromSpinner = findViewById(R.id.FromSpinner)
        toSpinner = findViewById(R.id.ToSpinner)
        dateOfTravel = findViewById(R.id.editTextDate)
        continueButton = findViewById(R.id.book)

//        // Initialize the arrays for spinners
//        val fromLocations = resources.getStringArray(R.array.from_locations)
//        val toLocations = resources.getStringArray(R.array.to_locations)

//        Log.d("from", fromLocations.toString())
//        Log.d("from", toLocations.toString())

        val fromLocations = arrayOf("India (IND)","America (USA)","Canada (CAN)","Germany (DEU)","Japan (JPN)","France (FRA)","Italy (ITA)", "Singapore (SGP)","China (PEK)","Bangladesh (DAC)","Maldives (MLE)", "Turkey (IST)")
        val toLocations = arrayOf("India (IND)","America (USA)","Canada (CAN)","Germany (DEU)","Japan (JPN)","France (FRA)","Italy (ITA)", "Singapore (SGP)","China (PEK)","Bangladesh (DAC)","Maldives (MLE)", "Turkey (IST)")
        // Create ArrayAdapter using the string arrays and a default spinner layout
        val fromAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, fromLocations)
        val toAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, toLocations)


        // Specify the layout to use when the list of choices appears
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapters to the spinners
        fromSpinner.adapter = fromAdapter
        toSpinner.adapter = toAdapter


        dateOfTravel.setOnClickListener {
            showDatePickerDialog()
        }

        continueButton.setOnClickListener {
            val intent = Intent(this, FlightBookActivity::class.java).apply {
                putExtra("firstName", firstName.text.toString())
                putExtra("lastName", lastName.text.toString())
                putExtra("gender", getSelectedGender())
                putExtra("from", fromSpinner.selectedItem.toString())
                putExtra("to", toSpinner.selectedItem.toString())
                putExtra("dateOfTravel", dateOfTravel.text.toString())
                putExtra("email", intent.getStringExtra("email"))
                putExtra("name", intent.getStringExtra("name"))

            }
            startActivity(intent)
        }
    }


    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            dateOfTravel.setText(selectedDate)
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun getSelectedGender(): String {
        return when (genderGroup.checkedRadioButtonId) {
            R.id.female -> "Female"
            R.id.male -> "Male"
            else -> ""
        }
    }
}