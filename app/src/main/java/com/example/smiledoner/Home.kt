package com.example.smiledoner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnNext = findViewById<Button>(R.id.btnHome1)
        btnNext.setOnClickListener {
            val intent = Intent(this,ChooseDonte::class.java)
            startActivity(intent)
        }


    }
}