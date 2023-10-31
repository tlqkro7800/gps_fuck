package com.example.gps_final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Shop_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        // 각 아이템을 클릭했을 때 해당 아이템을 구매하는 BuyItemActivity로 이동
        val java_Buy = findViewById<ImageView>(R.id.java_pen)
        val pental_Buy = findViewById<ImageView>(R.id.pental_graph_sharp)
        val zetStream_Buy = findViewById<ImageView>(R.id.zet_stream)
        val monami_Buy = findViewById<ImageView>(R.id.monami_pen_black)

        java_Buy.setOnClickListener{
            val intent = Intent(this, BuyActivity::class.java)
            startActivity(intent)
        }
        pental_Buy.setOnClickListener{
            val intent = Intent(this, BuyActivity::class.java)
            startActivity(intent)
        }
        zetStream_Buy.setOnClickListener{
            val intent = Intent(this, BuyActivity::class.java)
            startActivity(intent)
        }
        monami_Buy.setOnClickListener{
            val intent = Intent(this, BuyActivity::class.java)
            startActivity(intent)
        }

        //바텀바 화면 전환
        val homeButton = findViewById<Button>(R.id.home_button)
        val entireButton = findViewById<Button>(R.id.entire_button)

        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        entireButton.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
    }
}