package com.example.smiledoner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView


class home_new : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_new)



        val drawarLayout = findViewById<DrawerLayout>(R.id.drawarLayout)
        val imgMenu = findViewById<ImageView>(R.id.imgMenu)

        val navView = findViewById<NavigationView>(R.id.navDawar)
        navView.itemIconTintList = null
        imgMenu.setOnClickListener {
            drawarLayout.openDrawer(GravityCompat.START)
        }

        val btnNext = findViewById<Button>(R.id.donateNow)
        btnNext.setOnClickListener {
            val intent = Intent(this,ChooseDonte::class.java)
            startActivity(intent)
        }



    }



    }




