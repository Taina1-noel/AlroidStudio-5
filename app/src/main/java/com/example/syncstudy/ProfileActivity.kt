package com.example.syncstudy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class ProfileActivity : AppCompatActivity() {

    private val motivations = listOf(
        "Small progress is still progress.",
        "Your future self will thank you.",
        "Stay consistent. Stay focused.",
        "Show up for yourself today.",
        "One study session at a time."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val txtMotivation = findViewById<TextView>(R.id.txtMotivation)
        txtMotivation.text = motivations.random()
    }
}

