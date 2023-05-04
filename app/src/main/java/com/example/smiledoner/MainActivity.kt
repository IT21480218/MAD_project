package com.example.smiledoner


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        var btnNext = findViewById<Button>(R.id.donate1)
        btnNext.setOnClickListener {
            val intent = Intent(this,SmileDonor::class.java)
            startActivity(intent)
        }
    }



}



