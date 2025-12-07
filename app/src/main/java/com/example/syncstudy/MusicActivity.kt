package com.example.syncstudy

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MusicActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private var currentTrack = 0

    private val trackList = listOf(
        R.raw.focus1,
        R.raw.focus2,
        R.raw.focus3
    )

    private val trackNames = listOf(
        "Deep Focus Beats",
        "Calm Study Piano",
        "Rainy Ambience"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        val txtTrackName = findViewById<TextView>(R.id.txtTrackName)
        val btnPlayPause = findViewById<Button>(R.id.btnPlayPause)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnPrev = findViewById<Button>(R.id.btnPrev)
        val volumeSlider = findViewById<SeekBar>(R.id.seekVolume)

        // Initialize
        loadTrack(txtTrackName)

        btnPlayPause.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                btnPlayPause.text = "Pause"
            } else {
                mediaPlayer.pause()
                btnPlayPause.text = "Play"
            }
        }

        btnNext.setOnClickListener {
            nextTrack(txtTrackName, btnPlayPause)
        }

        btnPrev.setOnClickListener {
            previousTrack(txtTrackName, btnPlayPause)
        }

        volumeSlider.progress = 80
        volumeSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                val volume = progress / 100f
                mediaPlayer.setVolume(volume, volume)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }

    private fun loadTrack(label: TextView) {
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
        mediaPlayer = MediaPlayer.create(this, trackList[currentTrack])
        label.text = trackNames[currentTrack]
    }

    private fun nextTrack(label: TextView, btnPlayPause: Button) {
        currentTrack = (currentTrack + 1) % trackList.size
        loadTrack(label)
        mediaPlayer.start()
        btnPlayPause.text = "Pause"
    }

    private fun previousTrack(label: TextView, btnPlayPause: Button) {
        currentTrack = if (currentTrack == 0) trackList.size - 1 else currentTrack - 1
        loadTrack(label)
        mediaPlayer.start()
        btnPlayPause.text = "Pause"
    }

    override fun onDestroy() {
        mediaPlayer.release()
        super.onDestroy()
    }
}

