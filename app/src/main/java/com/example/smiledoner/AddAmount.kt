package com.example.smiledoner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smiledoner.model.amountModel
import com.example.smiledoner.model.cardModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddAmount : AppCompatActivity() {

    private lateinit var btnPayment: Button
    private lateinit var btnSave: Button
    private lateinit var amount: EditText
    private lateinit var save: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_amount)

        amount = findViewById(R.id.editTextTextPersonName)

        dbRef = FirebaseDatabase.getInstance().getReference("amounts")

        btnSave = findViewById(R.id.next)
        btnSave.setOnClickListener {
            saveAmount()
            val intent = Intent(this, MyDonationDetails::class.java)
            startActivity(intent)
        }
        btnPayment = findViewById(R.id.addPayment)
        btnPayment.setOnClickListener {
            val intent = Intent(this,PaymentDetails::class.java)
            startActivity(intent)
        }
    }

    private fun saveAmount() {

        //getting values
        val Amount = amount.text.toString()


        if (Amount.isEmpty()) {
            amount.error = "Please enter name"
        }


        val amtId = dbRef.push().key!!

        val amounts = amountModel(amtId, Amount)

        dbRef.child(amtId).setValue(amounts)
            .addOnCompleteListener {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                amount.text.clear()



            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }

    }

}