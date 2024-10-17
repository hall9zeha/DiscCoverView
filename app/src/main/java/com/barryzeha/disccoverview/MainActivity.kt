package com.barryzeha.disccoverview

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.barryzeha.library.components.DiscCoverView

class MainActivity : AppCompatActivity() {
    private var animState:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // when you use viewBinding should be casting to DiscCoverView ex:
        // (bind.albumCover as DiscCoverView) with access to methods
        val ivCoverView = findViewById<DiscCoverView>(R.id.albumCover)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnStop = findViewById<Button>(R.id.btnStop)
        val btnEnd = findViewById<Button>(R.id.btnEnd)

        btnStart.setOnClickListener {
            when(animState){
                0->{
                    ivCoverView.start()
                    animState = 1
                    btnStart.text = "Pause"
                }
                1->{
                    ivCoverView.pause()
                    animState = 2
                    btnStart.text = "Resume"
                }
                2->{
                    ivCoverView.resume()
                    animState = 1
                    btnStart.text = "Pause"
                }
            }

        }
        btnStop.setOnClickListener {
            ivCoverView.stop()
            animState=0
            btnStart.text = "Start"
        }
        btnEnd.setOnClickListener {
            ivCoverView.end()
            animState=0
            btnStart.text = "Start"
        }

    }
}