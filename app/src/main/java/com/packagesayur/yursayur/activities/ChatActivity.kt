package com.packagesayur.yursayur.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.packagesayur.yursayur.R

class ChatActivity : AppCompatActivity() {
    
    private lateinit var btnBacktoHome: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        btnBacktoHome = findViewById(R.id.btnBackToHome4)

        btnBacktoHome.setOnClickListener{
            finish()
        }
    }
}