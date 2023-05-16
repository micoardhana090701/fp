package com.packagesayur.yursayur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TokoActivity : AppCompatActivity() {

    private lateinit var tvDetailNamaToko : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toko)
        tvDetailNamaToko = findViewById(R.id.tvDetailNamaToko)
        loadToko()
    }

    private fun loadToko() {
        tvDetailNamaToko.text = "namatoko"

    }
}