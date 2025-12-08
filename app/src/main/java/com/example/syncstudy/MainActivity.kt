package com.example.syncstudy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.syncstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example buttons → navigate to activities

        binding.btnTimer.setOnClickListener {
            startActivity(Intent(this, TimerActivity::class.java))
        }
        binding.btnFlashcards.setOnClickListener {
            startActivity(Intent(this, FlashcardsActivity::class.java))
        }
        binding.btnMusic.setOnClickListener {
            startActivity(Intent(this, MusicActivity::class.java))
        }
        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}
