package com.example.smiledoner


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.smiledoner.model.cardModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class PaymentDetails : AppCompatActivity() {
    private lateinit var crdNumber: EditText
    private lateinit var crdName: EditText
    private lateinit var expDate: EditText
    private lateinit var cvv: EditText
    private lateinit var btnSaveData: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_details)

        crdNumber = findViewById(R.id.card_number)
        crdName = findViewById(R.id.card_name)
        expDate = findViewById(R.id.card_date)
        cvv = findViewById(R.id.card_cvv)
        btnSaveData = findViewById(R.id.button)

        dbRef = FirebaseDatabase.getInstance().getReference("cards")

        btnSaveData.setOnClickListener {
            saveCardDetails()
            val intent = Intent(this,ManageCard::class.java)
            startActivity(intent)

        }


    }

    private fun saveCardDetails() {

        //getting values
        val empNo = crdNumber.text.toString()
        val empName = crdName.text.toString()
        val empDate = expDate.text.toString()
        val empCvv = cvv.text.toString()

        if (empName.isEmpty()) {
            crdName.error = "Please enter name"
        }
        if (empNo.isEmpty()) {
            crdNumber.error = "Please enter valid card number"
        }
        if (empDate.isEmpty()) {
            expDate.error = "Please enter date"
        }
        if (empCvv.isEmpty()) {
            cvv.error = "Please enter cvv"
        }

        val empId = dbRef.push().key!!

        val card = cardModel(empId, empName, empNo, empDate, empCvv)

        dbRef.child(empId).setValue(card)
            .addOnCompleteListener {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                crdNumber.text.clear()
                crdName.text.clear()
                expDate.text.clear()
                cvv.text.clear()


            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }

    }

}


