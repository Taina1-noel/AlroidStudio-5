package com.example.syncstudy

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlashcardsActivity : AppCompatActivity() {

    // Flashcard questions & answers
    private val flashcards = listOf(
        "What is the powerhouse of the cell?" to "The mitochondria.",
        "What is 5 × 6?" to "30",
        "What is the capital of France?" to "Paris",
        "Define 'API'." to "A tool that allows two software programs to communicate.",
        "What does HTML stand for?" to "HyperText Markup Language"
    )

    private var currentIndex = 0
    private var showingAnswer = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcards)

        val txtCard = findViewById<TextView>(R.id.txtFlashcard)
        val btnToggle = findViewById<Button>(R.id.btnToggle)
        val btnNext = findViewById<Button>(R.id.btnNext)

        // Load first card
        txtCard.text = flashcards[currentIndex].first
        btnToggle.text = "Show Answer"

        btnToggle.setOnClickListener {
            showingAnswer = !showingAnswer
            txtCard.text = if (showingAnswer) flashcards[currentIndex].second
            else flashcards[currentIndex].first
            btnToggle.text = if (showingAnswer) "Show Question" else "Show Answer"
        }

        btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % flashcards.size
            showingAnswer = false
            txtCard.text = flashcards[currentIndex].first
            btnToggle.text = "Show Answer"
        }
    }
}

