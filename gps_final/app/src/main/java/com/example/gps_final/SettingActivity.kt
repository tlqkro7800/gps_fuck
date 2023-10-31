package com.example.gps_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val homeButton = findViewById<Button>(R.id.home_button)

        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val purchaseButton = findViewById<Button>(R.id.purchase_Button)

        purchaseButton.setOnClickListener {
            val intent = Intent(this, Shop_Activity::class.java)
            startActivity(intent)
        }
    }
}