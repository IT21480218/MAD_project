package com.example.smiledoner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smiledoner.model.amountModel
import com.example.smiledoner.model.cardModel
import com.google.firebase.database.DatabaseReference

class MyDonationDetails : AppCompatActivity() {

    private  lateinit var donRecyclerView: RecyclerView
    private lateinit var  tvLoadingData: TextView
    private lateinit var donList: ArrayList<cardModel>
    private lateinit var donList1: ArrayList<amountModel>
    private lateinit var dbRef : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_donation_details)

        var btnNext = findViewById<Button>(R.id.button5)
        btnNext.setOnClickListener {
            val intent = Intent(this,Home::class.java)
            startActivity(intent)
        }
    }
}