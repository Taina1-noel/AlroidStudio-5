package com.example.syncstudy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // buttons
        val btnTimer = findViewById<Button>(R.id.btnTimer)
        val btnFlashcards = findViewById<Button>(R.id.btnFlashcards)
        val btnMusic = findViewById<Button>(R.id.btnMusic)
        val btnProfile = findViewById<Button>(R.id.btnProfile)

        btnTimer.setOnClickListener {
            startActivity(Intent(this, TimerActivity::class.java))
        }

        btnFlashcards.setOnClickListener {
            startActivity(Intent(this, FlashcardsActivity::class.java))
        }

        btnMusic.setOnClickListener {
            startActivity(Intent(this, MusicActivity::class.java))
        }

        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}
