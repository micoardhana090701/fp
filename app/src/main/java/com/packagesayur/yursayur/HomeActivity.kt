package com.packagesayur.yursayur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.packagesayur.yursayur.adapter.ListSayurAdapter
import com.packagesayur.yursayur.data.sayurdata.SayurData
import com.packagesayur.yursayur.data.sayurdata.SayurEntity

class HomeActivity : AppCompatActivity() {

    private lateinit var rvSayur: RecyclerView
    private var list : ArrayList<SayurEntity> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvSayur = findViewById(R.id.rvSayur)
        rvSayur.setHasFixedSize(true)
        list.addAll(SayurData.listData)
        showRecyclerSayurList()
    }

    private fun showRecyclerSayurList() {
        rvSayur.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listSayurAdapter = ListSayurAdapter(list)
        rvSayur.adapter = listSayurAdapter
    }


}