package com.example.smiledoner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SmileDonor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smile_donor)

        val btnNext = findViewById<Button>(R.id.btnDonator)
        btnNext.setOnClickListener {
            val intent = Intent(this,home_new::class.java)
            startActivity(intent)
        }
    }
}