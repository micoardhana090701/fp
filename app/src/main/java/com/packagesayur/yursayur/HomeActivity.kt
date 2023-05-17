package com.packagesayur.yursayur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.packagesayur.yursayur.adapter.ListSayurAdapter
import com.packagesayur.yursayur.data.sayurdata.SayurData
import com.packagesayur.yursayur.data.sayurdata.SayurEntity

class HomeActivity : AppCompatActivity() {

    private lateinit var rvSayur: RecyclerView
    private lateinit var rvBuah: RecyclerView
    private var list : ArrayList<SayurEntity> = arrayListOf()

    private lateinit var ivFotoProfile: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvSayur = findViewById(R.id.rvSayur)
        rvSayur.setHasFixedSize(true)

        rvBuah = findViewById(R.id.rvBuah)
        rvBuah.setHasFixedSize(true)
        ivFotoProfile = findViewById(R.id.ivFotoProfil)

        list.addAll(SayurData.listData)
        showRecyclerSayurList()
        showRecyclerBuahList()

        // Click profile photo to exit
        ivFotoProfile.setOnClickListener() {
            FirebaseAuth.getInstance()
                .signOut()
                .also {
                    val intent= Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            
            Toast.makeText(this, "Berhasil Keluar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showRecyclerSayurList() {
        rvSayur.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listSayurAdapter = ListSayurAdapter(list)
        rvSayur.adapter = listSayurAdapter
    }

    private fun showRecyclerBuahList() {
        rvBuah.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listSayurAdapter = ListSayurAdapter(list)
        rvBuah.adapter = listSayurAdapter
    }


}