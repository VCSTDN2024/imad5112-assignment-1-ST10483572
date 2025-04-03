package com.example.mealsuggestionapp3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mealsuggestionapp3.R

class MainActivity : AppCompatActivity() {
    private lateinit var timeInput: EditText
    private lateinit var suggestionText: TextView
    private lateinit var suggestButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeInput = findViewById(R.id.timeInput)
        suggestionText = findViewById(R.id.suggestionText)
        suggestButton = findViewById(R.id.suggestButton)
        resetButton = findViewById(R.id.resetButton)

        suggestButton.setOnClickListener { suggestMeal() }
        resetButton.setOnClickListener { resetFields() }
    }

    private fun suggestMeal() {
        val timeOfDay = timeInput.text.toString().trim().lowercase()
        val suggestion = when (timeOfDay) {
            "morning" -> "Eggs and toast"
            "mid-morning" -> "Yogurt"
            "afternoon" -> "Prawn pasta "
            "mid-afternoon" -> " Protein bar"
            "dinner" -> "Ribeye steak with Baked patato"
            "after dinner snack" -> "Choclate brownie with ice cream"
            else -> "Enter: Morning, Mid-morning, Afternoon, Mid-afternoon, or Dinner"
        }
        suggestionText.text = suggestion
    }

    private fun resetFields() {
        timeInput.text.clear()
        suggestionText.text = "Your suggestion will appear here"
        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
    }
}