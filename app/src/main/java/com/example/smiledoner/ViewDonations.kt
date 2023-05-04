package com.example.smiledoner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ViewDonations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_donations)

        var btnNext = findViewById<Button>(R.id.button5)
        btnNext.setOnClickListener {
            val intent = Intent(this,Home::class.java)
            startActivity(intent)
        }
    }

}