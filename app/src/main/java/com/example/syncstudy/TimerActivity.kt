package com.example.syncstudy

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity() {

    private lateinit var txtCountdown: TextView
    private lateinit var circleProgress: ProgressBar

    private var timer: CountDownTimer? = null
    private var totalTimeInMillis: Long = 25 * 60 * 1000 // 25 minutes
    private var timeLeftInMillis: Long = totalTimeInMillis
    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        txtCountdown = findViewById(R.id.txtCountdown)
        circleProgress = findViewById(R.id.circleProgress)

        // Preset Buttons
        findViewById<Button>(R.id.btn5).setOnClickListener { setTimer(5) }
        findViewById<Button>(R.id.btn10).setOnClickListener { setTimer(10) }
        findViewById<Button>(R.id.btn15).setOnClickListener { setTimer(15) }
        findViewById<Button>(R.id.btn25).setOnClickListener { setTimer(25) }
        findViewById<Button>(R.id.btn60).setOnClickListener { setTimer(60) }

        // Control Buttons
        findViewById<Button>(R.id.btnStart).setOnClickListener { startTimer() }
        findViewById<Button>(R.id.btnPause).setOnClickListener { pauseTimer() }
        findViewById<Button>(R.id.btnReset).setOnClickListener { resetTimer() }

        updateTimerText()
    }

    private fun setTimer(min: Int) {
        totalTimeInMillis = min * 60 * 1000L
        timeLeftInMillis = totalTimeInMillis
        circleProgress.progress = 100
        updateTimerText()
    }

    private fun startTimer() {
        if (isRunning) return

        timer?.cancel()
        isRunning = true

        timer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(msLeft: Long) {
                timeLeftInMillis = msLeft
                updateTimerText()

                val percent = (msLeft.toFloat() / totalTimeInMillis.toFloat()) * 100
                circleProgress.progress = percent.toInt()
            }

            override fun onFinish() {
                txtCountdown.text = "DONE!"
                circleProgress.progress = 0
                isRunning = false
            }
        }.start()
    }

    private fun pauseTimer() {
        timer?.cancel()
        isRunning = false
    }

    private fun resetTimer() {
        timer?.cancel()
        timeLeftInMillis = totalTimeInMillis
        circleProgress.progress = 100
        updateTimerText()
        isRunning = false
    }

    private fun updateTimerText() {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60
        txtCountdown.text = String.format("%02d:%02d", minutes, seconds)
    }
}
