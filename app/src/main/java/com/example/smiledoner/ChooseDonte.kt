package com.example.smiledoner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChooseDonte : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_donte)

        val btnNext = findViewById<Button>(R.id.btnCash)
        btnNext.setOnClickListener {
            val intent = Intent(this,AddAmount::class.java)
            startActivity(intent)
        }
    }
}