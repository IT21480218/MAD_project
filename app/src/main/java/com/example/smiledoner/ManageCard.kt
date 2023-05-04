package com.example.smiledoner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.smiledoner.databinding.ActivityManageCardBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ManageCard : AppCompatActivity() {

    private lateinit var binding : ActivityManageCardBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageCardBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun readData(userName: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(userName).get().addOnSuccessListener {

            if (it.exists()){

                val firstname = it.child("firstName").value
                val lastName = it.child("lastName").value
                val age = it.child("age").value
                Toast.makeText(this,"Successfuly Read", Toast.LENGTH_SHORT).show()

                binding.cr.text = firstname.toString()
                binding.tvLastName.text = lastName.toString()
                binding.tvAge.text = age.toString()

            }else{

                Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()


            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


        }



    }
}
